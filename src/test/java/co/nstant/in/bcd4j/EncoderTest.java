/*
 * Copyright 2010-2018 Constantin Rack
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

import org.junit.Assert;
import org.junit.Test;

public class EncoderTest {

    @Test
    public void testByteArrayIsInitializedWithZeros() {
        int size = 1024 * 1024;
        byte[] array = new byte[size];
        for (int index = 0; index < size; index++) {
            Assert.assertEquals(0, array[index]);
        }
    }

}
