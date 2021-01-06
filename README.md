# bcd4j

[Binary coded decimals](http://en.wikipedia.org/wiki/Binary-coded_decimal) (BCD) in Java.
Both binary coded decimals and packed binary coded decimals are supported.

[![Build Status](https://travis-ci.org/c-rack/bcd4j.svg?branch=master)](https://travis-ci.org/c-rack/bcd4j)
[![Coverage Status](https://coveralls.io/repos/c-rack/bcd4j/badge.svg?branch=master&service=github)](https://coveralls.io/github/c-rack/bcd4j?branch=master)

## Architecture

> Frustra fit per plura quod potest fieri per pauciora
> &mdash; *[William of Ockham](https://en.wikipedia.org/wiki/Occam%27s_razor)*

This library provides only two public classes:
[BCD](https://github.com/c-rack/bcd4j/blob/master/src/main/java/co/nstant/in/bcd4j/BCD.java)
and
[PackedBCD](https://github.com/c-rack/bcd4j/blob/master/src/main/java/co/nstant/in/bcd4j/PackedBCD.java).
Internally, these two public classes are based on seven private classes, as shown here:

![Architecture](https://github.com/c-rack/bcd4j/blob/master/design.png)

## License

> Copyright 2010-2021 Constantin Rack
> 
> Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
>
> http://www.apache.org/licenses/LICENSE-2.0
> 
> Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
