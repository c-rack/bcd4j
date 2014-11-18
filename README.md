# bcd4j

[![Build Status](https://travis-ci.org/c-rack/bcd4j.svg?branch=master)](https://travis-ci.org/c-rack/bcd4j)
[![Coverage Status](http://img.shields.io/coveralls/c-rack/bcd4j/master.svg)](https://coveralls.io/r/c-rack/bcd4j?branch=master)

BCD4J implements [binary coded decimals](http://en.wikipedia.org/wiki/Binary-coded_decimal) in Java.
It encodes and decodes both binary coded decimals and packed binary coded decimals.

## Architecture

This library provides only two public classes:
[BCD](https://github.com/c-rack/bcd4j/blob/master/src/main/java/co/nstant/in/bcd4j/BCD.java)
and
[PackedBCD](https://github.com/c-rack/bcd4j/blob/master/src/main/java/co/nstant/in/bcd4j/PackedBCD.java).
Internally, this library consists of 7 more private classes, as shown here:

![Architecture](https://github.com/c-rack/bcd4j/blob/master/design.png)

## License

Copyright 2010-2014 Constantin Rack

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
