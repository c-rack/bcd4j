/*
 * Copyright 2010-2011 Constantin Rack.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.bcd4j;

/**
 * Decodes a BCD encoded byte array to {@link java.math.BigInteger}.
 */
class Decoder extends AbstractDecoder {
    
    /* (non-Javadoc)
     * @see org.bcd4j.AbstractDecoder#decodeAsString(byte[])
     */
    @Override
    protected final String decodeAsString(final byte[] bytes) {
        chars = new char[bytes.length];
        index = 0;
        decodeBytes(bytes);
        return String.valueOf(chars);
    }

    /**
     * Decodes a BCD encoded byte array to a char array.
     * @param bytes the byte array to decode.
     */
    private void decodeBytes(final byte[] bytes) {
        for (byte value : bytes) {
            chars[index++] = byteAsChar(value);
        }
    }

}
