(ns leiningen.deps-ancient
  (:require [deps-ancient.deps-ancient :as ancient]))

(defn deps-ancient
  ([project] (deps-ancient project "{}"))
  ([project opts]
   (ancient/-main)))
