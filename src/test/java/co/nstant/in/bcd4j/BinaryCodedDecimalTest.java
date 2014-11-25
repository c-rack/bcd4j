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

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

/**
 * The Class BinaryCodedDecimalTest.
 * 
 * @author Constantin Rack
 */
public class BinaryCodedDecimalTest {

    /**
     * Test method for {@link co.nstant.in.bcd4j.Decoder#decodeAsString(byte[])}.
     */
    @Test
    public void testEncodeDecode() {
        BigInteger original;
        BCD a;
        BCD b;

        for (long i = 0; i < 1000000; i++) {
            original = BigInteger.valueOf(i);
            a = new BCD(original);
            b = new BCD(a.toByteArray());
            assertEquals(original, b.toBigInteger());
            assertEquals(String.valueOf(i), a.toString());
        }
    }

    @Test
    public void testEncodeDecodeWithPadding() {
        BigInteger original;
        BCD a;
        BCD b;

        for (long i = 0; i < 1000000; i++) {
            original = BigInteger.valueOf(i);
            a = new BCD(original, 8);
            b = new BCD(a.toByteArray());
            assertEquals(original, b.toBigInteger());
        }
    }

}
