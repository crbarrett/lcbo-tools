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
package org.cbarrett.common.view;

import java.io.IOException;
import java.io.Writer;

import org.cbarrett.common.util.BOMUtility;
import org.springframework.oxm.XmlMappingException;
import org.springframework.oxm.xstream.XStreamMarshaller;

/**
 * @author cbarrett
 * 
 */
public class XStreamMarshallerWithPI extends XStreamMarshaller {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void marshalWriter(Object graph, Writer writer)
			throws XmlMappingException, IOException {
		writer.append(BOMUtility.getBOM(DEFAULT_ENCODING));
		writer.append("<?xml version=\"1.0\" encoding=\"" + DEFAULT_ENCODING
				+ "\"?>\n");
		super.marshalWriter(graph, writer);
	}
}
