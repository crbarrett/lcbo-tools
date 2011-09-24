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

import org.cbarrett.lcbo.domain.Product;

public interface LCBOService {
	public String resetDatasets();
	public String getMissingDatasets();
	
	public List<Product> getNewProductList();
	public List<Product> getNewProductList(String category);
	public List<Product> getNewProductList(String stockType, String category);
	
	public Product getProductDetails(String cspc);
	
	public void searchForProduct(String search);
	
	public void findStoresWithProduct(String cspc, String location);
	public void findStores(String location);
}
