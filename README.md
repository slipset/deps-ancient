[![Clojars Project](https://img.shields.io/clojars/v/deps-ancient.svg)](https://clojars.org/deps-ancient)

# deps-ancient

`deps-ancient` is a small wrapper around [ancient-clj](https://github.com/xsc/lein-ancient/tree/master/ancient-clj) which tells you if your `deps.edn` contains outdated deps.

## Usage

Merge the following into your `deps.edn` under the `:aliases` key like so:

```clojure
{:deps    {org.clojure/clojure       {:mvn/version "1.10.0"}
           org.clojure/clojurescript {:mvn/version "1.10.339"}  }

 :paths   ["src/cljc" "src/cljs" "target" "resources"]

 :aliases {:ancient   {:main-opts  ["-m" "deps-ancient.deps-ancient"]
                       :extra-deps {deps-ancient {:mvn/version "RELEASE"}}}
           :fig       {:main-opts ["-m" "figwheel.main"]}
           :build-dev {:main-opts ["-m" "figwheel.main" "-b" "dev" "-r"]}}
}
```

and invoke via:  `clojure -A:ancient`

Or, if you're somewhat something, merge this to your `project.clj`

```clojure
{:plugins [[deps-ancient "0.0.4"]]}
```

and run `lein deps ancient` to check your `deps.edn` files

## Inspiration

Thanks to @pmonks for asking for this on the [Clojurians](http://clojurians.net) #leiningen channel
## License

Copyright © 2018 Erik Assum

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
