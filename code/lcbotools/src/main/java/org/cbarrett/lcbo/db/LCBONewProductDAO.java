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

import java.util.List;

import javax.sql.DataSource;

import org.cbarrett.lcbo.domain.Product;

public interface LCBONewProductDAO {
	void setDataSource(DataSource ds);
	
	void truncate();
	void add(Product product);
	List<Product> selectAll();
	List<Product> selectAll(String category);
	List<Product> selectAll(String stockType, String category);
}
