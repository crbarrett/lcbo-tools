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
package org.cbarrett.lcbo.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cbarrett.lcbo.domain.Product;
import org.joda.time.DateTime;
import org.springframework.web.servlet.view.feed.AbstractAtomFeedView;

import com.sun.syndication.feed.atom.Content;
import com.sun.syndication.feed.atom.Entry;
import com.sun.syndication.feed.atom.Feed;

/**
 * @author cbarrett
 *
 */
public class NewProductAtomView extends AbstractAtomFeedView {

	@Override
	protected void buildFeedMetadata(Map<String, Object> model, Feed feed, HttpServletRequest request) {
		feed.setId("tag:lcbosuperstuff.com");
		feed.setTitle("New LCBO Product Listings");
		@SuppressWarnings("unchecked")
		List<Product> productList = (List<Product>) model.get("newProducts");
		
		// find max date as the updated date
		for (Product curr : productList) {
			DateTime date = (curr.getUpdatedAt() == null) ? new DateTime() : curr.getUpdatedAt();
			if (feed.getUpdated() == null || date.compareTo(new DateTime(feed.getUpdated())) > 0) {
				feed.setUpdated(date.toDate());
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.view.feed.AbstractAtomFeedView#buildFeedEntries(java.util.Map, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected List<Entry> buildFeedEntries(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		@SuppressWarnings("unchecked")
		List<Product> productList = (List<Product>) model.get("newProducts");
		List<Entry> entries = new ArrayList<Entry>(productList.size());

		for (Product curr : productList) {
			Entry entry = new Entry();
			
			String date = String.format("%1$tY-%1$tm-%1$td", (curr.getUpdatedAt() == null) ? new java.util.Date() : curr.getUpdatedAt().toDate());

			// see http://diveintomark.org/archives/2004/05/28/howto-atom-id#other
			entry.setId(String.format("tag:scotchbaby.com,%s:%s", date, curr.getId()));
			entry.setTitle(String.format("%s", curr.getName()));
			if (curr.getUpdatedAt() != null) {
				entry.setUpdated(curr.getUpdatedAt().toDate());
			} else {
				entry.setUpdated(new java.util.Date());
			}

			Content summary = new Content();
			summary.setValue(curr.toString());
			entry.setSummary(summary);
			
			entries.add(entry);
		}

		return entries;
	}

}
