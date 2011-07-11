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

import org.cbarrett.common.domain.DomainObject;
import org.codehaus.jackson.annotate.JsonProperty;

public class DatasetResponse extends GenericLCBOResponse implements DomainObject {
	private Dataset dataset;
	
	public Dataset getDataset() {
		return this.dataset;
	}
	
	@JsonProperty("result")
	public void setDataset(Dataset dataset) {
		this.dataset = dataset;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();

		result = prime * result + ((dataset == null) ? 0 : dataset.hashCode());
		
		return result;
	}
	@Override
	public boolean equals(Object otherObject) {
		boolean result = false;

		if (this == otherObject) {
			result = true;
		} else if (otherObject == null) {
			result = false;
		} else if (!(otherObject instanceof DatasetResponse)) {
			result = false;
		} else {
			DatasetResponse otherResponse = (DatasetResponse) otherObject;
			result = (
					  (super.equals(otherResponse))
					  && (dataset == null) ? otherResponse == null : dataset.equals(otherResponse.dataset)
					 );
		}
		return result;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(DatasetResponse.class.getSimpleName());
		sb.append("[datasetResponse: " + super.toString() + ",");
		sb.append("dataset: " + dataset.toString() + "]");
		return sb.toString();
	}	
}
