/*
 * Copyright 2010-2104 Constantin Rack
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

/**
 * The Class BinaryCodedDecimalEncoderTest.
 *
 * @author Constantin Rack
 */
public class BinaryCodedDecimalEncoderTest {

    private final static BigInteger i_1 = BigInteger.valueOf(-1);
    private final static BigInteger i0 = BigInteger.valueOf(0);
    private final static BigInteger i1 = BigInteger.valueOf(1);
    private final static BigInteger i12 = BigInteger.valueOf(12);
    private final static BigInteger i123 = BigInteger.valueOf(123);
    private final static BigInteger i1234 = BigInteger.valueOf(1234);

    /** The bcd encoder. */
    private transient Encoder bcdEncoder;

    /**
     * Before.
     */
    @Before
    public void before() {
        bcdEncoder = new Encoder(0);
    }

    /**
     * Test method for {@link co.nstant.in.bcd4j.Encoder#BcdEncoder(int)}.
     */
    @Test
    public void testConstructor() {
        bcdEncoder = new Encoder(123);
        assertEquals(123, bcdEncoder.getPadding());
    }

    /**
     * Test method for {@link co.nstant.in.bcd4j.Encoder#encode(long)}.
     */
    @Test
    public void testEncodeLong() {

        assertArrayEquals(new byte[] { 0 }, bcdEncoder.encode(i0));
        assertArrayEquals(new byte[] { 1 }, bcdEncoder.encode(i1));
        assertArrayEquals(new byte[] { 1, 2 }, bcdEncoder.encode(i12));
        assertArrayEquals(new byte[] { 1, 2, 3 }, bcdEncoder.encode(i123));
        assertArrayEquals(new byte[] { 1, 2, 3, 4 }, bcdEncoder.encode(i1234));
    }

    /**
     * Test method for {@link co.nstant.in.bcd4j.Encoder#setPadding(int)}.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetPaddingNegative() {
        bcdEncoder.setPadding(-1);
    }

    /**
     * Test method for {@link co.nstant.in.bcd4j.Encoder#setPadding(int)}.
     */
    @Test
    public void testSetPadding() {
        bcdEncoder.setPadding(6);
        assertArrayEquals(new byte[] { 0, 0, 0, 0, 0, 0 },
                        bcdEncoder.encode(i0));
        assertArrayEquals(new byte[] { 0, 0, 0, 0, 0, 1 },
                        bcdEncoder.encode(i1));
        assertArrayEquals(new byte[] { 0, 0, 0, 0, 1, 2 },
                        bcdEncoder.encode(i12));
        assertArrayEquals(new byte[] { 0, 0, 0, 1, 2, 3 },
                        bcdEncoder.encode(i123));
        assertArrayEquals(new byte[] { 0, 0, 1, 2, 3, 4 },
                        bcdEncoder.encode(i1234));
    }

    /**
     * Test method for {@link co.nstant.in.bcd4j.Encoder#encode(long)}.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testEncodeLongWithTooSmallPadding() {
        bcdEncoder.setPadding(2);
        bcdEncoder.encode(i123);
    }

    /**
     * Test method for {@link co.nstant.in.bcd4j.Encoder#encode(long)}.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testEncodeLongDoesNotAllowNegativeValues() {
        bcdEncoder.encode(i_1);
    }

    /**
     * Test method for
     * {@link co.nstant.in.bcd4j.Encoder#encode(java.math.BigInteger)}.
     */
    @Test
    public void testEncodeBigInteger() {
        assertArrayEquals(new byte[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2 },
                        bcdEncoder.encode(new BigInteger("123456789012")));
    }

}
