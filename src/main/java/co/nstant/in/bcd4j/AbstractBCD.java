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
package co.nstant.in.bcd4j;

import java.math.BigInteger;

/**
 * Base class for all binary coded decimals.
 */
abstract class AbstractBCD {

    /** The BCD encoded byte array */
    private final byte[] byteArray;

    /** The BigInteger value of this decimal */
    private final BigInteger bigInteger;

    /** The String value of this string */
    private final String string;

    /**
     * Constructor for encoded byte array.
     * @param value the value of this BCD as encoded as byte array.
     */
    public AbstractBCD(final byte[] value) {
        byteArray = value.clone();
        bigInteger = getDecoder().decode(byteArray);
        string = getDecoder().decodeAsString(byteArray);
    }

    /**
     * Constructor for BigInteger.
     * @param value the value of this BCD as {@link java.math.BigInteger}.
     */
    public AbstractBCD(final BigInteger value) {
        bigInteger = value;
        byteArray = getEncoder(0).encode(bigInteger);
        string = getDecoder().decodeAsString(byteArray);
    }

    /**
     * Constructor with padding.
     * @param value the value of this BCD as {@link java.math.BigInteger}.
     * @param padding the padding to use for this BCD.
     */
    public AbstractBCD(final BigInteger value, final int padding) {
        bigInteger = value;
        byteArray = getEncoder(padding).encode(bigInteger);
        string = getDecoder().decodeAsString(byteArray);
    }

    /**
     * Returns the BigInteger representation of this binary coded decimal.
     * @return a {@link java.math.BigInteger} with the value of this BCD.
     */
    public final BigInteger toBigInteger() {
        return bigInteger;
    }

    /**
     * Returns the byte representation of this binary coded decimal.
     * @return a byte array representing this BCD in encoded form.
     */
    public final byte[] toByteArray() {
        return byteArray.clone();
    }

    @Override
    public String toString() {
        return string;
    }

    /**
     * Factory method to get a decoder.
     * @return an {@link co.nstant.in.bcd4j.AbstractDecoder} for this BCD.
     */
    protected abstract AbstractDecoder getDecoder();

    /**
     * Factory method to get an encoder.
     * @return an {@link co.nstant.in.bcd4j.AbstractEncoder} for this BCD.
     */
    protected abstract AbstractEncoder getEncoder(final int padding);

}
