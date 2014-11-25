/*
 * Copyright 2010-2014 Constantin Rack.
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

import java.math.BigInteger;

/**
 * The Class PackedEncoder.
 */
class PackedEncoder extends AbstractEncoder {

    /** Number of bits to shift left to produce packed BCD format. */
    private static final int BIT_SHIFT = 4;

    /** Temporary byte array */
    private transient byte[] packedBcd;

    /**
     * Constructs an PackedBCD encoder.
     * @param paddingDigits number of digits in encoded byte array.
     */
    public PackedEncoder(final int paddingDigits) {
        super();
        setPadding(paddingDigits);
    }

    /* (non-Javadoc)
     * @see co.nstant.in.bcd4j.AbstractEncoder#encode(java.math.BigInteger)
     */
    @Override
    protected final byte[] encode(final BigInteger value) {
        bcd = new Encoder(getPadding()).encode(value);
        packedBcd = new byte[(bcd.length >> 1) + (bcd.length & 1)];
        pack();
        return packedBcd.clone();
    }

    /**
     * Pack two each bytes in one byte of the result array.
     */
    private void pack() {
        for (int i = alignFirstByte(), j = i; j < bcd.length; j += 2) {
            packedBcd[i] = (byte) (bcd[j] << BIT_SHIFT);
            packedBcd[i++] |= (byte) bcd[j + 1];
        }
    }

    /**
     * Pad if number of bytes is odd.
     * @param bcd the byte array to be packed.
     * @param packedBcd the byte array to pack into.
     */
    private int alignFirstByte() {
        if ((bcd.length & 1) == 1) {
            packedBcd[0] = bcd[0];
        }
        return (bcd.length & 1);
    }

}
