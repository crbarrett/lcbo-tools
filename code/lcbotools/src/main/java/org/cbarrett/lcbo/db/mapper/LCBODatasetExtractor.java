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
package org.cbarrett.lcbo.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.cbarrett.lcbo.domain.Dataset;
import org.springframework.jdbc.core.ResultSetExtractor;

public class LCBODatasetExtractor implements ResultSetExtractor<Dataset> {
	@Override
	public Dataset extractData(ResultSet rs) throws SQLException {
		Dataset ds = new Dataset();
		ds.setId(rs.getInt(1));
		ds.setCsvDump(rs.getString(2));
		return ds;
	}
}
