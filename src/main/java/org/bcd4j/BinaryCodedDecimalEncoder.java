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
class BinaryCodedDecimalEncoder extends AbstractBinaryCodedDecimalEncoder {

    /**
     * Constructor.
     *
     * @param paddingDigits number of digits in encoded byte array
     */
    public BinaryCodedDecimalEncoder(final int paddingDigits) {
        setPadding(paddingDigits);
    }

    /**
     * Encodes a value to its BCD representation. Uses left zero padding if
     * padding is set by {@link AbstractBinaryCodedDecimalEncoder#setPadding(int)}.
     *
     * @param value the value to be encoded
     * @return byte array with the BCD representation of value
     */
    @Override
    public final byte[] encode(final BigInteger value) {
        char[] digits = encodeBigInteger2Digits(value);
        byte[] bcd = allocate(digits.length);
        encodeDigits2Bcd(digits, bcd);
        return bcd;
    }

    /**
     * 
     * @param value
     * @return
     */
    private char[] encodeBigInteger2Digits(final BigInteger value) {
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
     * 
     * @param numberOfDigits
     */
    private void checkPadding(final int numberOfDigits) {
        if ((getPadding() > 0) && (getPadding() < numberOfDigits)) {
            throw new IllegalArgumentException("value exceeds padding");
        }
    }

    /**
     * 
     * @param size
     * @return
     */
    private byte[] allocate(final int size) {
        byte[] bcd = new byte[Math.max(getPadding(), size)];
        Arrays.fill(bcd, (byte) 0);
        return bcd;
    }

    /**
     * 
     * @param digits
     * @param bcd
     */
    private void encodeDigits2Bcd(final char[] digits, final byte[] bcd) {
        for (int i = 1; i <= digits.length; i++) {
            bcd[bcd.length - i] = (byte) (digits[digits.length - i] - '0');
        }
    }

}
