bcd4j
=====

[![Build Status](https://travis-ci.org/c-rack/bcd4j.svg?branch=master)](https://travis-ci.org/c-rack/bcd4j)

BCD4J implements [binary coded decimals](http://en.wikipedia.org/wiki/Binary-coded_decimal) in Java.
It encodes and decodes both binary coded decimals and packed binary coded decimals.

This library provides only two public classes:
[BCD](https://github.com/c-rack/bcd4j/blob/master/src/main/java/org/bcd4j/BCD.java)
and
[PackedBCD](https://github.com/c-rack/bcd4j/blob/master/src/main/java/org/bcd4j/PackedBCD.java).

Internally, this library consists of 7 more private classes, as shown here:
[![Architecture](https://github.com/c-rack/bcd4j/blob/master/design.png)]
