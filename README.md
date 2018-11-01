[![Clojars Project](https://img.shields.io/clojars/v/deps-ancient.svg)](https://clojars.org/deps-ancient)

# deps-ancient

`deps-ancient` is a small wrapper around [ancient-clj](https://github.com/xsc/lein-ancient/tree/master/ancient-clj) which tells you if your `deps.edn` contains outdated deps.

## Usage

Merge the following into your `deps.edn`
```clojure
{:ancient {:main-opts ["-m" "deps-ancient.deps-ancient"]
           :extra-deps {deps-ancient {:mvn/version "RELEASE"}}}}
```

## Inspiration

Thanks to @pmonks for asking for this on the [Clojurians](http://clojurians.net) #leiningen channel
## License

Copyright © 2018 Erik Assum

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
