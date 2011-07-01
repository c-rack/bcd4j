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

/**
 * Abstract base class for all BCD encoders.
 */
abstract class AbstractEncoder {

    /** The number of digits / bytes of the encoded result. */
    private transient int padding = 0;

    /** Temporary byte array */
    protected byte [] bcd;
    
    /** Temporary char array */
    protected char [] digits;
    
    /**
     * Getter method for padding.
     * @return the number of digits / bytes of the encoded result.
     */
    protected final int getPadding() {
        return padding;
    }

    /**
     * Encodes a value to its BCD representation. Uses left zero padding if
     * padding is set by {@link Encoder#setPadding(int)}.
     *
     * @param value the value to be encoded
     * @return byte array with the BCD representation of value
     */
    protected abstract byte[] encode(final BigInteger value);

    /**
     * Use this to automatically add zeros in front of the value during
     * encoding to get the desired number of bytes.
     *
     * @param paddingDigits
     *                number of digits in encoded byte array. If 0 (default),
     *                padding is off.
     */
    protected final void setPadding(final int paddingDigits) {
        paddingMustNotBeNegative(paddingDigits);
        padding = paddingDigits;
    }

    /**
     * 
     * @param paddingDigits
     */
    private void paddingMustNotBeNegative(final int paddingDigits) {
        if (paddingDigits < 0) {
            throw new IllegalArgumentException("padding must not be negative");
        }
    }

}
