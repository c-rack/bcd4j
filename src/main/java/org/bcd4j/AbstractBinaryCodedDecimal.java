package org.bcd4j;

import java.math.BigInteger;

/**
 * Base class for all binary coded decimals.
 */
abstract class AbstractBinaryCodedDecimal {

    /** The BCD encoded byte array */
    private byte[] byteArray;
    
    /** The BigInteger value of this decimal */
    private BigInteger bigInteger;

    /**
     * Constructor for encoded byte array.
     * @param value
     */
    public AbstractBinaryCodedDecimal(final byte[] value) {
        byteArray = value;
        bigInteger = getDecoder().decode(byteArray);
    }

    /**
     * Constructor for BigInteger.
     * @param value
     */
    public AbstractBinaryCodedDecimal(final BigInteger value) {
        bigInteger = value;
        byteArray = getEncoder(0).encode(bigInteger);
    }

    /**
     * Constructor with padding.
     * @param value
     * @param padding
     */
    public AbstractBinaryCodedDecimal(final BigInteger value,
        final int padding) {
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
        return byteArray;
    }

    /**
     * Factory method to get a decoder.
     * @return a decoder
     */
    abstract AbstractBinaryCodedDecimalDecoder getDecoder();

    /**
     * Factory method to get an encoder.
     * @return an encoder
     */
    abstract AbstractBinaryCodedDecimalEncoder getEncoder(final int padding);

}
