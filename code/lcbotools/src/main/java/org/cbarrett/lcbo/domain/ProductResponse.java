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

public class ProductResponse extends GenericLCBOResponse implements DomainObject {
	private Product product;
	
	public Product getProduct() {
		return this.product;
	}
	
	@JsonProperty("result")
	public void setProduct(Product product) {
		this.product= product;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();

		result = prime * result + ((product == null) ? 0 : product.hashCode());
		
		return result;
	}
	@Override
	public boolean equals(Object otherObject) {
		boolean result = false;

		if (this == otherObject) {
			result = true;
		} else if (otherObject == null) {
			result = false;
		} else if (!(otherObject instanceof ProductResponse)) {
			result = false;
		} else {
			ProductResponse otherResponse = (ProductResponse) otherObject;
			result = (
					  (super.equals(otherResponse))
					  && (product == null) ? otherResponse == null : product.equals(otherResponse.product)
					 );
		}
		return result;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(ProductResponse.class.getSimpleName());
		sb.append("[productResponse: " + super.toString() + ",");
		sb.append("product: " + product.toString() + "]");
		return sb.toString();
	}	
}
