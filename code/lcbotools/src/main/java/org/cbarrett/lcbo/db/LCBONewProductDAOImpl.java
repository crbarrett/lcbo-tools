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
package org.cbarrett.lcbo.db;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.cbarrett.lcbo.db.mapper.LCBOProductRowMapper;
import org.cbarrett.lcbo.domain.Product;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class LCBONewProductDAOImpl implements LCBONewProductDAO {
		
    static private Log _log = LogFactory.getLog("LCBONewProductDAOImpl");
		    
    private SimpleJdbcTemplate simpleJdbcTemplate;    
    private SimpleJdbcInsert insertDataset;
    
    public void setDataSource(DataSource dataSource) {
        this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
        this.insertDataset = 
            new SimpleJdbcInsert(dataSource).withTableName("NEW_PRODUCTS");    
	}

	public void truncate() {
		this.simpleJdbcTemplate.getJdbcOperations().execute(
				"truncate table new_products");	
	}	
	
	public void add(Product product) {
        Map<String, Object> parameters = new HashMap<String, Object>(17);
        parameters.put("cspc", product.getId());
        parameters.put("producer_name", product.getProducer_name());
        parameters.put("name", product.getName());
        parameters.put("description", product.getDescription());
		parameters.put("alcohol_content", product.getAlcohol_content());
		parameters.put("is_dead", product.getIs_dead());
		parameters.put("is_discontinued", product.getIs_discontinued());
		parameters.put("stock_type", product.getStock_type());
		parameters.put("price_in_cents", product.getPrice_in_cents());
		parameters.put("origin", product.getOrigin());
		parameters.put("primary_category", product.getPrimary_category());
		parameters.put("secondary_category", product.getSecondary_category());
		parameters.put("released_on", (product.getReleasedOn() == null) ? null : new java.sql.Timestamp(product.getReleasedOn().getMillis()));
		parameters.put("inventory_count", product.getInventory_count());
		parameters.put("updated_at", new java.sql.Timestamp(product.getUpdatedAt().getMillis()));
		parameters.put("image_thumb_url", product.getImageThumbUrl());
		parameters.put("image_url", product.getImageUrl());
        
        try {
        	this.insertDataset.execute(parameters);
        } catch (DuplicateKeyException e) {
        	_log.info("Skipped duplicate entry; " + product.getId() + " (" + product.getName() + ")");
        }
	}
	
	public List<Product> selectAll() {
		return this.simpleJdbcTemplate.query("select CSPC, PRODUCER_NAME, NAME, DESCRIPTION, ALCOHOL_CONTENT, IS_DISCONTINUED, IS_DEAD, STOCK_TYPE, PRICE_IN_CENTS, ORIGIN, PRIMARY_CATEGORY, SECONDARY_CATEGORY, RELEASED_ON, INVENTORY_COUNT, UPDATED_AT, IMAGE_THUMB_URL, IMAGE_URL from NEW_PRODUCTS",
				new LCBOProductRowMapper());		
	}
	
}
