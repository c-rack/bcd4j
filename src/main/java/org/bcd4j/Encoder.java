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

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Encodes a number to its BCD (binary coded digit) representation.
 */
class Encoder extends AbstractEncoder {

    /**
     * Constructor.
     * @param paddingDigits number of digits in encoded byte array
     */
    public Encoder(final int paddingDigits) {
        super();
        setPadding(paddingDigits);
    }

    /* (non-Javadoc)
     * @see org.bcd4j.AbstractEncoder#encode(BigInteger)
     */
    @Override
    public final byte[] encode(final BigInteger value) {
        encodeBigIntegerToDigits(value);
        bcd = allocateByteArray(digits.length);
        encodeDigitsToBcd();
        return bcd;
    }

    /**
     * Converts a BigInteger value to char array.
     * @param value the BigInteger value
     */
    private void encodeBigIntegerToDigits(final BigInteger value) {
        checkValue(value);
        digits = value.toString().toCharArray();
        checkPadding(digits.length);
    }

    /**
     * Verifies that value is not negative.
     * @param value the value to be checked.
     */
    private void checkValue(final BigInteger value) {
        if (value.signum() == -1) {
            throw new IllegalArgumentException("value must not be negative");
        }
    }

    /**
     * Throws an exception if padding is invalid.
     * @param numberOfDigits
     */
    private void checkPadding(final int numberOfDigits) {
        if ((getPadding() > 0) && (getPadding() < numberOfDigits)) {
            throw new IllegalArgumentException("value exceeds padding");
        }
    }

    /**
     * Allocates a byte array and fills it with zeros.
     * @param size the size of the array
     * @return a byte array filled with zeros.
     */
    private byte[] allocateByteArray(final int size) {
        bcd = new byte[Math.max(getPadding(), size)];
        Arrays.fill(bcd, (byte) 0);
        return bcd;
    }

    /**
     * Converts digits encoded as chars to a BCD encoded byte array.
     * @param digits the char array to be encoded
     * @param bcd the target byte array
     */
    private void encodeDigitsToBcd() {
        for (int i = 1; i <= digits.length; i++) {
            bcd[bcd.length - i] = (byte) (digits[digits.length - i] - '0');
        }
    }

}
