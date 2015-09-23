/*
 * Copyright 2010-2015 Constantin Rack.
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
 * Represents a Binary Coded Decimal (BCD).
 * @author Constantin Rack
 */
public final class BCD extends AbstractBCD {

    /**
     * Constructs a BCD from a byte array.
     * @param value the byte array
     */
    public BCD(final byte[] value) {
        super(value);
    }

    /**
     * Constructs a BCD from a {@link java.math.BigInteger}.
     * @param value the BigInteger.
     */
    public BCD(final BigInteger value) {
        this(value, 0);
    }

    /**
     * Constructs a BCD from a {@link java.math.BigInteger} with padding.
     * @param value the BigInteger.
     * @param padding total number of digits of this BCD.
     */
    public BCD(final BigInteger value, final int padding) {
        super(value, padding);
    }

    /* (non-Javadoc)
     * @see co.nstant.in.bcd4j.AbstractBCD#getDecoder()
     */
    @Override
    protected AbstractDecoder getDecoder() {
        return new Decoder();
    }

    /* (non-Javadoc)
     * @see co.nstant.in.bcd4j.AbstractBCD#getEncoder(int)
     */
    @Override
    protected AbstractEncoder getEncoder(final int padding) {
        return new Encoder(padding);
    }

}
