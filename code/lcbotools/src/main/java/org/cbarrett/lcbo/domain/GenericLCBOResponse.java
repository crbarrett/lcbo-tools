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

public abstract class GenericLCBOResponse implements DomainObject {
	private int status;
	private String message;
	
	public int getStatus() {
		return this.status;
	}
	public String getMessage() {
		return this.message;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + status;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		
		return result;
	}
	@Override
	public boolean equals(Object otherObject) {
		boolean result = false;

		if (this == otherObject) {
			result = true;
		} else if (otherObject == null) {
			result = false;
		} else if (!(otherObject instanceof GenericLCBOResponse)) {
			result = false;
		} else {
			GenericLCBOResponse otherResponse = (GenericLCBOResponse) otherObject;
			result = (
					  (status == otherResponse.status)
					  && ((message == null) ? otherResponse.message == null : message.equals(otherResponse.message))
					 );
		}
		return result;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(GenericLCBOResponse.class.getSimpleName());
		sb.append("[status: " + Integer.valueOf(status).toString() + ",");
		sb.append("message: " + message + "]");
		return sb.toString();
	}}
