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
 * Base class for all binary coded decimals.
 */
abstract class AbstractBCD {

    /** The BCD encoded byte array */
    private byte[] byteArray;
    
    /** The BigInteger value of this decimal */
    private BigInteger bigInteger;

    /**
     * Constructor for encoded byte array.
     * @param value
     */
    public AbstractBCD(final byte[] value) {
        byteArray = value;
        bigInteger = getDecoder().decode(byteArray);
    }

    /**
     * Constructor for BigInteger.
     * @param value
     */
    public AbstractBCD(final BigInteger value) {
        bigInteger = value;
        byteArray = getEncoder(0).encode(bigInteger);
    }

    /**
     * Constructor with padding.
     * @param value
     * @param padding
     */
    public AbstractBCD(final BigInteger value, final int padding) {
        bigInteger = value;
        byteArray = getEncoder(padding).encode(bigInteger);
    }

    /**
     * Returns the BigInteger representation of this binary coded decimal.
     * @return the BigInteger
     */
    public final BigInteger toBigInteger() {
        return bigInteger;
    }

    /**
     * Returns the byte representation of this binary coded decimal.
     * @return the byte array
     */
    public final byte[] toByteArray() {
        byte [] resultByteArray = new byte[byteArray.length];
        System.arraycopy(byteArray, 0, resultByteArray, 0, byteArray.length);
        return resultByteArray;
    }

    /**
     * Factory method to get a decoder.
     * @return a decoder
     */
    abstract AbstractDecoder getDecoder();

    /**
     * Factory method to get an encoder.
     * @return an encoder
     */
    abstract AbstractEncoder getEncoder(final int padding);

}
