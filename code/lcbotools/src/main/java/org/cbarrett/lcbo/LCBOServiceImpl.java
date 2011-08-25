/**
 *  Copyright 2011 Chris Barrett
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.cbarrett.lcbo;

import java.util.List;

import org.cbarrett.lcbo.db.LCBODatasetDAO;
import org.cbarrett.lcbo.db.LCBONewProductDAO;
import org.cbarrett.lcbo.domain.Dataset;
import org.cbarrett.lcbo.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;

@Service
public class LCBOServiceImpl implements LCBOService {
	
	@Autowired
	LCBOClient lcboClient;
	
	@Autowired
	private ObjectifyFactory objectifyFactory;
	
	@Transactional
	public String resetDatasets() {
		
		Objectify ofy = objectifyFactory.begin();
		
		// drop the current lcbo dataset content
		//lcboDatasetDAO.truncate();
		//lcboNewProductDAO.truncate();
		
		// find newest dataset (all, but paged)
		List<Dataset> ds = lcboClient.getDatasetsFirstPage();
				
		Dataset newDs = ds.get(0);
		// store latest
		ofy.put(newDs);

		List<String> cspcList = newDs.getAddedProductIds();
		int newProductCount = cspcList.size();
		// fetch new product info
		for (int j = 0; j < newProductCount; j++) {
			String currentCspc = cspcList.get(j);
			Product currentProduct = lcboClient.getProduct(currentCspc);
			
			// save new product
			ofy.put(currentProduct);
		}

		return newDs.toString();
	}
	
	@Transactional
	public String getMissingDatasets() {
		// find newest dataset (all, but paged)
		List<Dataset> ds = lcboClient.getDatasetsFirstPage();
		
		Objectify ofy = objectifyFactory.begin();

		// current latest dataset
		long currentDsId = ds.get(0).getId();
		long maxStoredDsId = -1;
		maxStoredDsId = 1;
				//ofy.getMaxId();
		if (maxStoredDsId == -1) {
			// store latest
			ofy.put(ds.get(0));			
		}
		
		// retrieve missing datasets (or start with latest)
		if (maxStoredDsId != -1) {
			for (long i = maxStoredDsId + 1; i <= currentDsId; i++) {
				Dataset missingDs = lcboClient.getDataset(i);

				// store this ds
				ofy.put(missingDs);
				
				List<String> cspcList = missingDs.getAddedProductIds();
				int newProductCount = cspcList.size();
				// fetch new product info
				for (int j = 0; j < newProductCount; j++) {
					String currentCspc = cspcList.get(j);
					Product currentProduct = lcboClient.getProduct(currentCspc);
					
					// save new product (skip existing cspcs)
					ofy.put(currentProduct);
				}
			}
		}
		
		return ds.get(0).toString();
	}

	public List<Product> getNewProductList() {
		Objectify ofy = objectifyFactory.begin();
		List<Product> products = ofy.query(Product.class).list();
		
		return products;
	}
	
	public Product getProductDetails(String cspc) {
		return lcboClient.getProduct(cspc);
	}
	
	public void searchForProduct(String search) {
		
	}
	
	public void findStoresWithProduct(String cspc, String location) {
		
	}
	
	public void findStores(String location) {
		
	}
}
