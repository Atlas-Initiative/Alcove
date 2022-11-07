# Alcove
<p>
    <img alt="CircleCI" src="https://img.shields.io/circleci/build/github/Atlas-Initiative/Alcove/main?logo=circleci&style=flat-square">
    <img alt="GitHub tag (latest SemVer pre-release)" src="https://img.shields.io/github/v/tag/Atlas-Initiative/Alcove?include_prereleases&label=Version&logo=Github&style=flat-square">
    <img alt="JitPack" src="https://img.shields.io/jitpack/version/com.github.Atlas-Initiative/Alcove?logo=gradle&style=flat-square">
</p>

## Purpose

This library was built to provide a clean, lightweight solution for logging on the jvm with kotlin.

## API

Alcove follows the same principles as [Timber](https://github.com/jakewharton/timber) as far as usage goes. There are
some slight differences in feature sets however.

##### Blooming your sprouts

Sprouts are platform specific logging implementations such as using PrintStream's for standard JVM logging.

JVM Print Stream

```kotlin
Alcove.bloom(Sprout.createTagged("My App"))
```

JVM Debug

```kotlin
Alcove.bloom(Sprout.createDebug())
```

Custom sprouts can be created from
the [ISprout](https://github.com/Atlas-Initiative/Alcove/blob/main/src/main/kotlin/org/atlasin/alcove/ISprout.kt)
interface.

##### Logging

All logging is handled from
the [Alcove](https://github.com/Atlas-Initiative/Alcove/blob/main/src/main/kotlin/org/atlasin/alcove/Alcove.kt)
functions.

Alcove supports debug, verbose, info, warning, error, and wtf logs. Logging calls are passed to the plot implementation,
where the sprouts handle the log action themselves.

```kotlin
Alcove.d("Hello there from the Alcove!")
```

You can tag logs to allow easy searching and visualization of logging.

```kotlin
Alcove.tag("My Custom System").i("Initialized system")
```

##### Lazy evaluation

Kotlin string concatenation means that strings are evaluated regardless of if they are actually logged or not.
Using the lazy function allows you to bypass this and only evaluate if the message is actually logged.

Debug messages for example, may not be logged in production

```kotlin
alcove {
    "Alcove version $version"
}   
```

You can also change the log level

```kotlin
alcove(LogLevel.E) {
    "Oh no, something went wrong!"
}
```

## Install

```kotlin
repositories {
    maven(url = "https://jitpack.io")
}

dependencies {
    implementation("com.github.Atlas-Initiative:Alcove:1.x.x")
}
```
