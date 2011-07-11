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
package org.cbarrett.lcbo.domain;

import java.util.List;

import org.cbarrett.common.domain.DomainObject;
import org.codehaus.jackson.annotate.JsonProperty;

public class DatasetsResponse extends GenericLCBOResponse implements DomainObject {
	private Pager pager;
	private List<Dataset> pageOfDatasets;
	
	public Pager getPager() {
		return this.pager;
	}
	public List<Dataset> getPageOfDatasets() {
		return this.pageOfDatasets;
	}
	
	@JsonProperty("pager")
	public void setPager(Pager pager) {
		this.pager = pager;
	}
	@JsonProperty("result")
	public void setDatasets(List<Dataset> datasets) {
		this.pageOfDatasets = datasets;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((pageOfDatasets == null) ? 0 : pageOfDatasets.hashCode());
		
		return result;
	}
	@Override
	public boolean equals(Object otherObject) {
		boolean result = false;

		if (this == otherObject) {
			result = true;
		} else if (otherObject == null) {
			result = false;
		} else if (!(otherObject instanceof DatasetsResponse)) {
			result = false;
		} else {
			DatasetsResponse otherDatasets = (DatasetsResponse) otherObject;
			result = (
					  (super.equals(otherDatasets))
					  && (pageOfDatasets == null) ? otherDatasets == null : pageOfDatasets.equals(otherDatasets.pageOfDatasets)
					 );
		}
		return result;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(DatasetsResponse.class.getSimpleName());
		sb.append("[datasetsResponse: " + super.toString() + ",");
		sb.append("datasets: " + pageOfDatasets.toString() + "]");
		return sb.toString();
	}
}
