(ns deps-ancient.deps-ancient
  (:require [ancient-clj.core :as ancient]
            [clojure.edn :as edn]
            [clojure.tools.deps.alpha :as deps]
            [clojure.string :as str]))

(defn deps-edn []
  (deps/find-edn-maps))

(defn deps [deps-edn]
  (->> deps-edn
       :aliases
       vals
       (map :extra-deps)
       (into (:deps deps-edn))))

(def always-latest? #{"RELEASE" "SNAPSHOT"})

(defn outdated? [[artifact version]]
  (when-let [v (:mvn/version version)]
    (when-not (always-latest? v)
      (let [latest (ancient/artifact-outdated? (str artifact))
            latest-version (:version-string latest)]
        (when-not (= latest-version v)
          [artifact {:mvn/version v
                     :latest/version latest-version}])))))

(defn print-results! [outdated-deps]
  (if (seq outdated-deps)
    (do
      (println "The following deps are ancient:")
      (doseq [[artifact versions] outdated-deps]
        (println (str artifact ": current-version " (:mvn/version versions) ", latest version " (:latest/version versions))))
      1)
    (do (println "All versions are up to date!")
        0)))

(defn -main []
  (->> (deps-edn)
       deps
       (keep outdated?)
       (print-results!)
       (System/exit)))

(comment
  (def deps (deps (deps-edn)))
  deps

(ancient/artifact-outdated? "ancient-clj")

(outdated-deps? deps)
(-main)
 )
