package org.bcd4j;

import java.math.BigInteger;

public final class PackedBinaryCodedDecimal extends AbstractBinaryCodedDecimal {

    public PackedBinaryCodedDecimal(final byte[] value) {
        super(value);
    }

    public PackedBinaryCodedDecimal(final BigInteger value) {
        super(value);
    }

    @Override
    protected AbstractBinaryCodedDecimalDecoder getDecoder() {
        return new PackedBinaryCodedDecimalDecoder();
    }

    @Override
    protected AbstractBinaryCodedDecimalEncoder getEncoder(final int padding) {
        return new PackedBinaryCodedDecimalEncoder(padding);
    }
    
}
