/*
 * Copyright 2010 Constantin Rack
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
 * The Class PackedBinaryCodedDecimalTest.
 * 
 * @author Constantin Rack
 */
public class PackedBinaryCodedDecimalTest {

    @Test
    public void testEncodeDecode() {
        BigInteger original;
        PackedBCD a;
        PackedBCD b;

        for (long i = 0; i < 1000000; i++) {
            original = BigInteger.valueOf(i);
            a = new PackedBCD(original);
            b = new PackedBCD(a.toByteArray());
            assertEquals(original, b.toBigInteger());
        }
    }

    @Test
    public void testEncodeDecodeWithPadding() {
        BigInteger original;
        PackedBCD a;
        PackedBCD b;

        for (long i = 0; i < 1000000; i++) {
            original = BigInteger.valueOf(i);
            a = new PackedBCD(original, 8);
            b = new PackedBCD(a.toByteArray());
            assertEquals(original, b.toBigInteger());
        }
    }

}
