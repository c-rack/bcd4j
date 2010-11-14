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
        setPadding(paddingDigits);
    }

    /* (non-Javadoc)
     * @see org.bcd4j.AbstractEncoder#encode(BigInteger)
     */
    @Override
    public final byte[] encode(final BigInteger value) {
        char[] digits = encodeBigIntegerToDigits(value);
        byte[] bcd = allocateByteArray(digits.length);
        encodeDigitsToBcd(digits, bcd);
        return bcd;
    }

    /**
     * 
     * @param value
     * @return
     */
    private char[] encodeBigIntegerToDigits(final BigInteger value) {
        checkValue(value);
        char[] digits = value.toString().toCharArray();
        checkPadding(digits.length);
        return digits;
    }

    /**
     * 
     * @param value
     */
    private void checkValue(final BigInteger value) {
        if (value.signum() == -1) {
            throw new IllegalArgumentException("value must not be negative");
        }
    }

    /**
     * Verifies if padding is valid.
     * @param numberOfDigits
     */
    private void checkPadding(final int numberOfDigits) {
        if ((getPadding() > 0) && (getPadding() < numberOfDigits)) {
            throw new IllegalArgumentException("value exceeds padding");
        }
    }

    /**
     * Allocates a byte array and fills it with zeros.
     * @param size
     * @return
     */
    private byte[] allocateByteArray(final int size) {
        byte[] bcd = new byte[Math.max(getPadding(), size)];
        Arrays.fill(bcd, (byte) 0);
        return bcd;
    }

    /**
     * Converts digits encoded as chars to a BCD encoded byte array.
     * @param digits the char array to be encoded
     * @param bcd the target byte array
     */
    private void encodeDigitsToBcd(final char[] digits, final byte[] bcd) {
        for (int i = 1; i <= digits.length; i++) {
            bcd[bcd.length - i] = (byte) (digits[digits.length - i] - '0');
        }
    }

}
