/*
 * Copyright 2010-2015 Constantin Rack
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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Before;
import org.junit.Test;

import co.nstant.in.bcd4j.PackedEncoder;

/**
 * The Class PackedBinaryCodedDecimalEncoderTest.
 */
public class PackedBinaryCodedDecimalEncoderTest {

    private final static BigInteger i_1 = BigInteger.valueOf(-1);
    private final static BigInteger i0 = BigInteger.valueOf(0);
    private final static BigInteger i1 = BigInteger.valueOf(1);
    private final static BigInteger i12 = BigInteger.valueOf(12);
    private final static BigInteger i123 = BigInteger.valueOf(123);
    private final static BigInteger i1234 = BigInteger.valueOf(1234);

    /** The packed bcd encoder. */
    private transient PackedEncoder packedBcdEncoder;

    /**
     * Create a new PackedBcdEncoder before each test.
     */
    @Before
    public void before() {
        packedBcdEncoder = new PackedEncoder(0);
    }

    /**
     * Test method for {@link co.nstant.in.bcd4j.PackedEncoder#PackedBcdEncoder(int)}.
     */
    @Test
    public void testConstructor() {
        packedBcdEncoder = new PackedEncoder(123);
        assertEquals(123, packedBcdEncoder.getPadding());
    }

    /**
     * Test method for {@link co.nstant.in.bcd4j.PackedEncoder#PackedBcdEncoder(int)}.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor2() {
        packedBcdEncoder = new PackedEncoder(-123);
    }

    /**
     * Test method for {@link co.nstant.in.bcd4j.Encoder#encode(long)}.
     */
    @Test
    public void testEncodeLong() {
        assertArrayEquals(new byte[] { 0x00 },
                        packedBcdEncoder.encode(i0));
        assertArrayEquals(new byte[] { 0x01 },
                        packedBcdEncoder.encode(i1));
        assertArrayEquals(new byte[] { 0x12 },
                        packedBcdEncoder.encode(i12));
        assertArrayEquals(new byte[] { 0x01, 0x23 },
                        packedBcdEncoder.encode(i123));
        assertArrayEquals(new byte[] { 0x12, 0x34 },
                        packedBcdEncoder.encode(i1234));

        packedBcdEncoder.setPadding(4);

        assertArrayEquals(new byte[] { 0x00, 0x01 },
                        packedBcdEncoder.encode(i1));
        assertArrayEquals(new byte[] { 0x00, 0x12 },
                        packedBcdEncoder.encode(i12));
        assertArrayEquals(new byte[] { 0x01, 0x23 },
                        packedBcdEncoder.encode(i123));
        assertArrayEquals(new byte[] { 0x12, 0x34 },
                        packedBcdEncoder.encode(i1234));
    }

    /**
     * Test method for {@link co.nstant.in.bcd4j.Encoder#encode(long)}.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testEncodeLongDoesNotAllowNegativeValues() {
        packedBcdEncoder.encode(i_1);
    }

    /**
     * Test method for
     * {@link co.nstant.in.bcd4j.PackedEncoder#encode(java.math.BigInteger)}.
     */
    @Test
    public void testEncodeBigInteger() {
        assertArrayEquals(new byte[] { 0x00 },
                        packedBcdEncoder.encode(BigInteger.valueOf(0)));
        assertArrayEquals(new byte[] { 0x01 },
                        packedBcdEncoder.encode(BigInteger.valueOf(1)));
        assertArrayEquals(new byte[] { 0x12 },
                        packedBcdEncoder.encode(BigInteger.valueOf(12)));
        assertArrayEquals(new byte[] { 0x01, 0x23 },
                        packedBcdEncoder.encode(BigInteger.valueOf(123)));
        assertArrayEquals(new byte[] { 0x12, 0x34 },
                        packedBcdEncoder.encode(BigInteger.valueOf(1234)));
    }

}
