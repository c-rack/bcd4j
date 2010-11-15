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
 * Represents a Packed Binary Coded Decimal (BCD).
 *
 * @author Constantin Rack
 */
public final class PackedBCD extends AbstractBCD {

    /**
     * Constructs a PackedBCD from a byte array.
     *
     * @param value the byte array
     */
    public PackedBCD(final byte[] value) {
        super(value);
    }

    /**
     * Constructs a PackedBCD from a {@link java.math.BigInteger}.
     * 
     * @param value the BigInteger.
     */
    public PackedBCD(final BigInteger value) {
        super(value);
    }

    /**
     * Constructs a PackedBCD from a {@link java.math.BigInteger} with padding.
     * 
     * @param value the BigInteger.
     * @param padding total number of digits of this BCD.
     */
    public PackedBCD(final BigInteger value, final int padding) {
        super(value, padding);
    }

    /* (non-Javadoc)
     * @see org.bcd4j.AbstractBCD#getDecoder()
     */
    @Override
    protected AbstractDecoder getDecoder() {
        return new PackedDecoder();
    }

    /* (non-Javadoc)
     * @see org.bcd4j.AbstractBCD#getEncoder(int)
     */
    @Override
    protected AbstractEncoder getEncoder(final int padding) {
        return new PackedEncoder(padding);
    }
    
}
