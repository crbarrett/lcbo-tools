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

import org.codehaus.jackson.annotate.JsonProperty;

public class Pager {
	int recordsPerPage;
	int totalRecordCount;
	int currentPageRecordCount;
	boolean isFirstPage;
	boolean isFinalPage;
	int currentPage;
	String currentPagePath;
	int nextPage;
	String nextPagePath;
	int previousPage;
	String previousPagePath;
	int finalPage;
	String finalPagePath;
//	"pager": {
//    "records_per_page": 20,
//    "total_record_count": 73,
//    "current_page_record_count": 20,
//    "is_first_page": true,
//    "is_final_page": false,
//    "current_page": 1,
//    "current_page_path": "/datasets?order=total_products.desc&page=1",
//    "next_page": 2,
//    "next_page_path": "/datasets?order=total_products.desc&page=2",
//    "previous_page": null,
//    "previous_page_path": null,
//    "final_page": 4,
//    "final_page_path": "/datasets?order=total_products.desc&page=4"
//  }

	public int getRecordsPerPage() {
		return recordsPerPage;
	}
	public int getTotalRecordCount() {
		return totalRecordCount;
	}
	public int getCurrentPageRecordCount() {
		return currentPageRecordCount;
	}
	public boolean isFirstPage() {
		return isFirstPage;
	}
	public boolean isFinalPage() {
		return isFinalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public String getCurrentPagePath() {
		return currentPagePath;
	}
	public int getNextPage() {
		return nextPage;
	}
	public String getNextPagePath() {
		return nextPagePath;
	}
	public int getPreviousPage() {
		return previousPage;
	}
	public String getPreviousPagePath() {
		return previousPagePath;
	}
	public int getFinalPage() {
		return finalPage;
	}
	public String getFinalPagePath() {
		return finalPagePath;
	}

	@JsonProperty("records_per_page")
	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}
	@JsonProperty("total_record_count")
	public void setTotalRecordCount(int totalRecordCount) {
		this.totalRecordCount = totalRecordCount;
	}
	@JsonProperty("current_page_record_count")
	public void setCurrentPageRecordCount(int currentPageRecordCount) {
		this.currentPageRecordCount = currentPageRecordCount;
	}
	@JsonProperty("is_first_page")
	public void setFirstPage(boolean isFirstPage) {
		this.isFirstPage = isFirstPage;
	}
	@JsonProperty("is_final_page")
	public void setFinalPage(boolean isFinalPage) {
		this.isFinalPage = isFinalPage;
	}
	@JsonProperty("current_page")
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	@JsonProperty("current_page_path")
	public void setCurrentPagePath(String currentPagePath) {
		this.currentPagePath = currentPagePath;
	}
	@JsonProperty("next_page")
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	@JsonProperty("next_page_path")
	public void setNextPagePath(String nextPagePath) {
		this.nextPagePath = nextPagePath;
	}
	@JsonProperty("previous_page")
	public void setPreviousPage(int previousPage) {
		this.previousPage = previousPage;
	}
	@JsonProperty("previous_page_path")
	public void setPreviousPagePath(String previousPagePath) {
		this.previousPagePath = previousPagePath;
	}
	@JsonProperty("final_page")
	public void setFinalPage(int finalPage) {
		this.finalPage = finalPage;
	}
	@JsonProperty("final_page_path")
	public void setFinalPagePath(String finalPagePath) {
		this.finalPagePath = finalPagePath;
	}	

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(Pager.class.getSimpleName());
		sb.append("[records: " + Integer.valueOf(recordsPerPage).toString() + ",");
		sb.append("totalRecordCount: " + Integer.valueOf(totalRecordCount).toString() + ",");
		sb.append("currentPageRecordCount: " + Integer.valueOf(currentPageRecordCount).toString() + ",");
		sb.append("isFirstPage: " + Boolean.valueOf(isFirstPage).toString() + ",");
		sb.append("isFinalPage: " + Boolean.valueOf(isFinalPage).toString() + ",");
		sb.append("currentPage: " + Integer.valueOf(currentPage).toString() + ",");
		sb.append("currentPagePath: " + currentPagePath + ",");
		sb.append("nextPage: " + Integer.valueOf(nextPage).toString() + ",");
		sb.append("nextPagePath: " + nextPagePath + ",");
		sb.append("previousPage: " + Integer.valueOf(previousPage).toString() + ",");
		sb.append("previousPagePath: " + previousPagePath + ",");
		sb.append("finalPage: " + Integer.valueOf(finalPage).toString() + ",");
		sb.append("finalPagePath: " + finalPagePath + "]");
		return sb.toString();
	}
}
