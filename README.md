# _ZenKit4J_

![License](https://img.shields.io/github/license/GothicKit/ZenKitCS?label=License&color=important)
![Java](https://img.shields.io/static/v1?label=Java&message=17&color=informational)
![Platforms](https://img.shields.io/static/v1?label=Supports&message=Linux%20x64%20|%20Windows%20x64%20|%20MacOS&color=blueviolet)
![Version](https://img.shields.io/github/v/tag/GothicKit/ZenKitCS?label=Version&sort=semver)

A Java-library wrapping the [ZenKit](https://github.com/GothicKit/ZenKit) library for parsing game assets of
[PiranhaBytes'](https://www.piranha-bytes.com/) early 2000's games [Gothic](https://en.wikipedia.org/wiki/Gothic_(video_game))
and [Gothic II](https://en.wikipedia.org/wiki/Gothic_II).

> [!TIP]
> You can obtain a prebuilt version of this library from [Maven Central](https://mvnrepository.com/artifact/dev.gothickit/zenkit)!

## building

You will need:

* The Java Development Kit (OpenJDK compatible), anything from Java 17 onwards should work
* Git

To build _ZenKit4J_ from scratch, just open a terminal in a directory of your choice and run

```bash
git clone --recursive https://github.com/GothicKit/ZenKit4J
cd ZenKit4J
./gradlew shadowJar
```

You will find the built library in `build/libs/`.
