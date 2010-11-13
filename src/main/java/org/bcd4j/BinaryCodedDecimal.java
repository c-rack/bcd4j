package org.bcd4j;

import java.math.BigInteger;

public final class BinaryCodedDecimal extends AbstractBinaryCodedDecimal {

    public BinaryCodedDecimal(final byte[] value) {
        super(value);
    }

    public BinaryCodedDecimal(final BigInteger value) {
        super(value);
    }

    @Override
    protected AbstractBinaryCodedDecimalDecoder getDecoder() {
        return new BinaryCodedDecimalDecoder();
    }

    @Override
    protected AbstractBinaryCodedDecimalEncoder getEncoder(final int padding) {
        return new BinaryCodedDecimalEncoder(padding);
    }
    
}
