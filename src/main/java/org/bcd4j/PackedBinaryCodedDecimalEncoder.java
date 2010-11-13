/*
 * Copyright 2010 Constantin Rack.
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

import java.math.BigInteger;

/**
 * The Class PackedBcdEncoder.
 */
class PackedBinaryCodedDecimalEncoder extends
    AbstractBinaryCodedDecimalEncoder {

    /** Number of bits to shift left to produce packed BCD format. */
    static final int BIT_SHIFT = 4;
    
    /**
     * Constructor.
     *
     * @param paddingDigits number of digits in encoded byte array.
     */
    public PackedBinaryCodedDecimalEncoder(final int paddingDigits) {
        setPadding(paddingDigits);
    }

    /* (non-Javadoc)
     * @see org.bcd4j.AbstractBinaryCodedDecimalsEncoder#encode(java.math.BigInteger)
     */
    @Override
    public final byte[] encode(final BigInteger value) {
        byte[] bcd = new BinaryCodedDecimalEncoder(getPadding()).encode(value);
        byte[] packedBcd = new byte[(bcd.length >> 1) + (bcd.length & 1)];
        pack(bcd, packedBcd);
        return packedBcd;
    }

    /**
     * Pad if number of bytes is odd.
     */
    private int alignFirstByte(final byte[] bcd, final byte[] packedBcd) {
        if ((bcd.length & 1) == 1) {
            packedBcd[0] = bcd[0];
        }
        return (bcd.length & 1);
    }

    /**
     * Pack two each bytes in one byte of the result array.
     */
    private void pack(final byte[] bcd, final byte[] packedBcd) {
        int i = alignFirstByte(bcd, packedBcd);
        for (int j = i; j < bcd.length; j += 2) {
            packedBcd[i++] = (byte) ((bcd[j] << BIT_SHIFT) | bcd[j + 1]);
        }
    }
    
}
