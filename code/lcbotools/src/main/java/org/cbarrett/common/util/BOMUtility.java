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

import java.io.UnsupportedEncodingException;

/**
 * @author cbarrett
 * 
 */
public class BOMUtility {

	public static String getBOM(String enc) throws UnsupportedEncodingException {
		if ("UTF-8".equals(enc)) {
			byte[] bom = new byte[3];
			bom[0] = (byte) 0xEF;
			bom[1] = (byte) 0xBB;
			bom[2] = (byte) 0xBF;
			return new String(bom, enc);
		} else if ("UTF-16BE".equals(enc)) {
			byte[] bom = new byte[2];
			bom[0] = (byte) 0xFE;
			bom[1] = (byte) 0xFF;
			return new String(bom, enc);
		} else if ("UTF-16LE".equals(enc)) {
			byte[] bom = new byte[2];
			bom[0] = (byte) 0xFF;
			bom[1] = (byte) 0xFE;
			return new String(bom, enc);
		} else if ("UTF-32BE".equals(enc)) {
			byte[] bom = new byte[4];
			bom[0] = (byte) 0x00;
			bom[1] = (byte) 0x00;
			bom[2] = (byte) 0xFE;
			bom[3] = (byte) 0xFF;
			return new String(bom, enc);
		} else if ("UTF-32LE".equals(enc)) {
			byte[] bom = new byte[4];
			bom[0] = (byte) 0x00;
			bom[1] = (byte) 0x00;
			bom[2] = (byte) 0xFF;
			bom[3] = (byte) 0xFE;
			return new String(bom, enc);
		} else {
			return null;
		}
	}
}
