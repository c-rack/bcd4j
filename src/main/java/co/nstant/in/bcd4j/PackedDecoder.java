/*
 * Copyright 2010-2018 Constantin Rack.
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
package co.nstant.in.bcd4j;

/**
 * The Class PackedDecoder.
 */
class PackedDecoder extends AbstractDecoder {

    /** Number of bits to shift left to produce packed BCD format. */
    private static final int BIT_SHIFT = 4;

    /** Bit mask to get only the lowest four bits of a byte. */
    private static final byte BIT_MASK = 0x0F;

    /*
     * (non-Javadoc)
     * 
     * @see co.nstant.in.bcd4j.AbstractDecoder#decodeAsString(byte[])
     */
    @Override
    protected final String decodeAsString(final byte[] bytes) {
        chars = new char[bytes.length << 1];
        index = 0;
        decodeBytes(bytes);
        return String.valueOf(chars);
    }

    /**
     * Unpacks byte array values to char array.
     * 
     * @param bytes
     *            the byte array to decode
     */
    private void decodeBytes(final byte[] bytes) {
        for (byte value : bytes) {
            chars[index++] = byteAsChar(BIT_MASK & (value >> BIT_SHIFT));
            chars[index++] = byteAsChar(BIT_MASK & value);
        }
    }

}
