[![](https://jitpack.io/v/ArenaReturns/Tuna-Bytes.svg)](https://jitpack.io/#ArenaReturns/Tuna-Bytes)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

### This is a fork of Revxrsal's Tuna Bytes library tweaked for use in Arena Returns wrapper.

# Tuna Bytes
![A tuna byte :)](https://i.imgur.com/15VLkMI.jpg)
Tuna-bytes is an all-purpose powerful class and bytecode manipulation mixins for Java, which is intended at those with minimal understanding of the Java bytecode structure.

## Features
- Full support for the notorious Java 9+ versions, as well as Java 8.
- Does not require access to the source code of classes, and works well even on third-party resources.
- Does not require any knowledge of the Java bytecode.
- Requires zero overhead to get started. Just add Tuna-Bytes as a dependency and as an annotation processor, and Tuna-Bytes will handle the rest.
- Does not require any additional Java execution arguments, like what Java agents do.

## Index
Check the [wiki](https://github.com/ReflxctionDev/Tuna-Bytes/wiki) for a full overview on the library.
1. [Maven setup](https://github.com/ReflxctionDev/Tuna-Bytes/wiki/Maven-Setup)
2. [Gradle setup](https://github.com/ReflxctionDev/Tuna-Bytes/wiki/Gradle-Setup)
3. [Getting started](https://github.com/ReflxctionDev/Tuna-Bytes/wiki/Getting-started)
4. [**Example**: Overwrite a method](https://github.com/ReflxctionDev/Tuna-Bytes/wiki/Overwrite)
5. [**Example**: Inject into a method](https://github.com/ReflxctionDev/Tuna-Bytes/wiki/Injecting)
6. [**Example**: Create accessors for inaccessible fields and methods](https://github.com/ReflxctionDev/Tuna-Bytes/wiki/Accessors)
7. [**Example**: Mirroring a field or a method](https://github.com/ReflxctionDev/Tuna-Bytes/wiki/Mirroring)

# Drawbacks
Just like any other bytecode manipulation library, **manipulating a class after is has been loaded is not possible** without things like instrumentation, agents or such. Tuna-bytes assumes that any class it is about to modify has not been loaded, and will otherwise throw an exception. To suppress `Class XX has already been loaded` exceptions, use `MixinsBootstrap.init(true)`
