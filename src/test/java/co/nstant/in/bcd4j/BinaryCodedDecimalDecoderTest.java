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

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Before;
import org.junit.Test;

/**
 * The Class BinaryCodedDecimalDecoderTest.
 * 
 * @author Constantin Rack
 */
public class BinaryCodedDecimalDecoderTest {

    /** The bcd decoder. */
    private transient Decoder bcdDecoder;

    /**
     * Before.
     */
    @Before
    public void before() {
        bcdDecoder = new Decoder();
    }

    /**
     * Test method for {@link co.nstant.in.bcd4j.Decoder#decodeAsString(byte[])}.
     */
    @Test
    public void testDecodeAsString() {
        assertEquals("0",
                        bcdDecoder.decodeAsString(new byte[] { 0 }));
        assertEquals("1",
                        bcdDecoder.decodeAsString(new byte[] { 1 }));
        assertEquals("9",
                        bcdDecoder.decodeAsString(new byte[] { 9 }));
        assertEquals("12",
                        bcdDecoder.decodeAsString(new byte[] { 1, 2 }));
        assertEquals("99",
                        bcdDecoder.decodeAsString(new byte[] { 9, 9 }));
        assertEquals("123",
                        bcdDecoder.decodeAsString(new byte[] { 1, 2, 3 }));
        assertEquals("1234",
                        bcdDecoder.decodeAsString(new byte[] { 1, 2, 3, 4 }));
        assertEquals("00123",
                        bcdDecoder.decodeAsString(new byte[] { 0, 0, 1, 2, 3 }));
    }

    /**
     * Test method for {@link co.nstant.in.bcd4j.Decoder#decodeAsString(byte[])}.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testDecodeAsStringWithIllegalArgument() {
        bcdDecoder.decodeAsString(new byte[] { 2, 4, 6, 8, 10, 12, 14 });
    }

    /**
     * Test method for {@link co.nstant.in.bcd4j.Decoder#decodeAsString(byte[])}.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testDecodeAsStringWithIllegalArgument2() {
        bcdDecoder.decodeAsString(new byte[] { 2, 4, 6, 8, -1 });
    }

    /**
     * Test method for {@link co.nstant.in.bcd4j.Decoder#decodeAsString(byte[])}.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testDecodeAsStringWithIllegalArgument3() {
        bcdDecoder.decodeAsString(new byte[] { 10 });
    }

    /**
     * Test method for {@link co.nstant.in.bcd4j.Decoder#decode(byte[])}.
     */
    @Test
    public void testDecode() {
        assertEquals(BigInteger.valueOf(0),
                        bcdDecoder.decode(new byte[] { 0 }));
        assertEquals(BigInteger.valueOf(1),
                        bcdDecoder.decode(new byte[] { 1 }));
        assertEquals(BigInteger.valueOf(12),
                        bcdDecoder.decode(new byte[] { 1, 2 }));
        assertEquals(BigInteger.valueOf(123),
                        bcdDecoder.decode(new byte[] { 1, 2, 3 }));
        assertEquals(BigInteger.valueOf(1234),
                        bcdDecoder.decode(new byte[] { 1, 2, 3, 4 }));
        assertEquals(BigInteger.valueOf(123),
                        bcdDecoder.decode(new byte[] { 0, 0, 1, 2, 3 }));
    }

    /**
     * Test method for {@link co.nstant.in.bcd4j.Decoder#decode(byte[])}.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testDecodeWithIllegalArgument() {
        bcdDecoder.decode(new byte[] { 2, 4, 6, 8, 10, 12, 14 });
    }

}
