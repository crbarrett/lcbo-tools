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

import org.cbarrett.common.util.TimeFormats;
import org.cbarrett.lcbo.domain.Product;
import org.joda.time.DateTime;
import org.springframework.web.servlet.view.feed.AbstractAtomFeedView;

import com.sun.syndication.feed.atom.Content;
import com.sun.syndication.feed.atom.Entry;
import com.sun.syndication.feed.atom.Feed;
import com.sun.syndication.feed.atom.Link;
import com.sun.syndication.feed.atom.Person;

/**
 * Atom feed view.  Validate with http://feedvalidator.org/
 * 
 * @author cbarrett
 */
public class NewProductAtomView extends AbstractAtomFeedView {

	private static final String LCBOBABY_LINK = "http://maggie.dynalias.org/lcbotools/newproducts.atom";
	private static final String LCBO_LINK = "http://lcbo.com/lcbo-ear/lcbo/product/details.do?language=EN&itemNumber=";
			
	@Override
	protected void buildFeedMetadata(Map<String, Object> model, Feed feed, HttpServletRequest request) {
		feed.setId("http://lcbobaby.com/");
		feed.setTitle("New LCBO Product Listings");
		
		List<Link> alternateLinks = new ArrayList<Link>();
		Link link = new Link();
		link.setHref(LCBOBABY_LINK);
		link.setType("application/atom+xml");
		link.setRel("self");
		alternateLinks.add(link);		
		feed.setAlternateLinks(alternateLinks);
		
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
			entry.setId(String.format("tag:lcbobaby.com,%s:%s", date, curr.getId()));
			entry.setTitle(String.format("%s", curr.getName()));
			
			List<Link> alternateLinks = new ArrayList<Link>();
			Link link = new Link();
			link.setHref(LCBO_LINK + curr.getId());
			link.setType("text/html");
			link.setRel("alternate");
			alternateLinks.add(link);
			entry.setAlternateLinks(alternateLinks);
			
			Person p = new Person();
			p.setName("Chris Barrett");
			List<Person> authors = new ArrayList<Person>();
			authors.add(p);
			entry.setAuthors(authors);
			
			if (curr.getUpdatedAt() != null) {
				entry.setUpdated(curr.getUpdatedAt().toDate());
			} else {
				entry.setUpdated(new java.util.Date());
			}

			StringBuilder body = new StringBuilder();
			body.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
			body.append("<html>");
			body.append("<head>");
			body.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");

			body.append("<title>LCBO Product</title>");
			body.append("</head>");
			body.append("<body>");

			body.append(curr.getProducer_name());
			body.append("<br>");
			body.append(curr.getPrimary_category());
			body.append(" (" + curr.getSecondary_category() + ")");
			body.append("<br>");
			body.append(curr.getOrigin());
			body.append("<br>");
			if (curr.getReleasedOn() != null) {
				body.append("Released On: ");
				body.append(curr.getReleasedOn().toString(TimeFormats.iso8601DateOnlyFormat));
				body.append("<br>");
			}
			body.append("<b>");
			body.append(curr.getId());
			body.append("         ");
			body.append("$" + curr.getPrice_in_cents()/100.00);
			
			body.append("</b>");
			body.append("</body>");
			body.append("</html>");
			
			List<Content> contents = new ArrayList<Content>();
			Content content = new Content();
			content.setType(Content.HTML);
			content.setValue(body.toString());
			contents.add(content);
			entry.setContents(contents);
			
			entries.add(entry);
		}

		return entries;
	}

}
