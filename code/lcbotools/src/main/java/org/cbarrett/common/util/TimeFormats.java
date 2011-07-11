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
package org.cbarrett.common.util;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * @author cbarrett
 * 
 */
public final class TimeFormats {
	public static final DateTimeFormatter iso8601Format = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ssZZ");
	public static final DateTimeFormatter iso8601DateOnlyFormat = DateTimeFormat.forPattern("yyyy-MM-dd");
	
	public static final DateTimeFormatter stdInputFormat = iso8601Format;
	public static final DateTimeFormatter stdOutputFormat = iso8601Format;
}
