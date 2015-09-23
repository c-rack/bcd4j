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
 * The Class PackedBinaryCodedDecimalDecoderTest.
 */
public class PackedBinaryCodedDecimalDecoderTest {

    /** The packed bcd decoder. */
    private transient PackedDecoder decoder;

    /**
     * Before.
     */
    @Before
    public void before() {
        decoder = new PackedDecoder();
    }

    /**
     * Test method for
     * {@link co.nstant.in.bcd4j.PackedDecoder#decodeAsString(byte[])}.
     */
    @Test
    public void testDecodeAsString() {
        assertEquals("00",
                        decoder.decodeAsString(new byte[] { 0x00 }));
        assertEquals("01",
                        decoder.decodeAsString(new byte[] { 0x01 }));
        assertEquals("12",
                        decoder.decodeAsString(new byte[] { 0x12 }));
        assertEquals("0123",
                        decoder.decodeAsString(new byte[] { 0x01, 0x23 }));
        assertEquals("1234",
                        decoder.decodeAsString(new byte[] { 0x12, 0x34 }));
        assertEquals("000123",
                        decoder.decodeAsString(new byte[] { 0x00, 0x01, 0x23 }));
    }

    /**
     * Test method for {@link co.nstant.in.bcd4j.Decoder#decode(byte[])}.
     */
    @Test
    public void testDecode() {
        assertEquals(BigInteger.valueOf(0),
                        decoder.decode(new byte[] { 0x00 }));
        assertEquals(BigInteger.valueOf(1),
                        decoder.decode(new byte[] { 0x01 }));
        assertEquals(BigInteger.valueOf(12),
                        decoder.decode(new byte[] { 0x12 }));
        assertEquals(BigInteger.valueOf(123),
                        decoder.decode(new byte[] { 0x01, 0x23 }));
        assertEquals(BigInteger.valueOf(1234),
                        decoder.decode(new byte[] { 0x12, 0x34 }));
        assertEquals(BigInteger.valueOf(123),
                        decoder.decode(new byte[] { 0x00, 0x01, 0x23 }));
    }

    /**
     * Test method for {@link co.nstant.in.bcd4j.Decoder#decode(byte[])}.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testDecodeIllegalByteValues1() {
        decoder.decode(new byte[] { 0x0A });
    }

    /**
     * Test method for {@link co.nstant.in.bcd4j.Decoder#decode(byte[])}.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testDecodeIllegalByteValues2() {
        decoder.decode(new byte[] { (byte) 0xA0 });
    }

    /**
     * Test method for {@link co.nstant.in.bcd4j.Decoder#decode(byte[])}.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testDecodeIllegalByteValues3() {
        decoder.decode(new byte[] { (byte) 0xAA });
    }

}
