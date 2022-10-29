# lisp-game-jam

A roguelike or something like it for [Lisp Game Jam 2022](https://itch.io/jam/lisp-game-jam-2022).

## Installation

Download from https://github.com/noahtheduke/lisp-game-jam

## Usage

Run the project directly, via `:exec-fn`:

    $ clojure -M:run

Run the project's tests (they'll fail until you edit them):

    $ clojure -T:build test

Run the project's CI pipeline and build an uberjar (this will fail until you edit the tests to pass):

    $ clojure -T:build ci

This will produce an updated `pom.xml` file with synchronized dependencies inside the `META-INF`
directory inside `target/classes` and the uberjar in `target`. You can update the version (and SCM tag)
information in generated `pom.xml` by updating `build.clj`.

If you don't want the `pom.xml` file in your project, you can remove it. The `ci` task will
still generate a minimal `pom.xml` as part of the `uber` task, unless you remove `version`
from `build.clj`.

Run that uberjar:

    $ java -jar target/lisp-game-jam-0.1.0-SNAPSHOT.jar

If you remove `version` from `build.clj`, the uberjar will become `target/lisp-game-jam-standalone.jar`.

## Options

FIXME: listing of options this app accepts.

## Examples

...

### Bugs

...

## License

Copyright © 2022 Noah

Distributed under the Mozilla Public License, v. 2.0.
