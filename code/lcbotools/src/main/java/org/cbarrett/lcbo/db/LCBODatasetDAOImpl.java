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

import org.cbarrett.lcbo.db.mapper.LCBODatasetRowMapper;
import org.cbarrett.lcbo.domain.Dataset;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class LCBODatasetDAOImpl implements LCBODatasetDAO {
    private SimpleJdbcTemplate simpleJdbcTemplate;    
    private SimpleJdbcInsert insertDataset;
    
    public void setDataSource(DataSource dataSource) {
        this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
        this.insertDataset = 
            new SimpleJdbcInsert(dataSource).withTableName("DATASET");    
	}

	public void truncate() {
		this.simpleJdbcTemplate.getJdbcOperations().execute(
				"truncate table DATASET");	
	}	
	public void add(Dataset ds) {
        Map<String, Object> parameters = new HashMap<String, Object>(4);
        parameters.put("id_dataset", ds.getId());
        parameters.put("total_products", ds.getTotalProducts());
        parameters.put("total_stores", ds.getTotalStores());
        parameters.put("csv_location", ds.getCsvDump());
        
        this.insertDataset.execute(parameters);	
	}

	public int delete(int id) {
		return this.simpleJdbcTemplate.update("delete from DATASET where ID = ?",
				new Object[] { id }, Integer.class );
		
	}
	
	public List<Dataset> select(int id) {
		return this.simpleJdbcTemplate.query(
				"select ID_DATASET, CSV_LOCATION from DATASET where ID = ?",
				new LCBODatasetRowMapper(),
				new Object[] { id }, Integer.class);
	}
	public List<Dataset> selectAll() {
		return this.simpleJdbcTemplate.query("select ID_REF_DISTILLERY_STATUS, STATUS_NAME, STATUS_DESCRIPTION from REF_DISTILLERY_STATUS",
				new LCBODatasetRowMapper());		
	}
	public int getMaxId() {
		return this.simpleJdbcTemplate.queryForInt("select max(ID_DATASET) from DATASET");
	}
}
