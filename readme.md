# _phoenix java interface_

![License](https://img.shields.io/github/license/GothicKit/phoenix-java-interface?label=License&color=important)
![Java](https://img.shields.io/static/v1?label=Java&message=11&color=informational)
![Version](https://img.shields.io/github/v/tag/GothicKit/phoenix-java-interface?label=Version&sort=semver)

Java bindings for the [phoenix](https://github.com/lmichaelis/phoenix) library for parsing game assets of
[PiranhaBytes'](https://www.piranha-bytes.com/) early 2000's games [Gothic](https://en.wikipedia.org/wiki/Gothic_(video_game))
and [Gothic II](https://en.wikipedia.org/wiki/Gothic_II). This library is based on [phoenix-shared-interface](https://github.com/GothicKit/phoenix-shared-interface).

## building

You will need:

* The Java Development Kit (OpenJDK compatible), anything from Java 11 onwards should work
* Git

To build _phoenix-java-interface_ from scratch, just open a terminal in a directory of your choice and run

```bash
git clone --recursive https://github.com/GothicKit/phoenix-java-interface
cd phoenix-java-interface
./gradlew shadowJar
```

You will find the built library in `build/libs/`.
