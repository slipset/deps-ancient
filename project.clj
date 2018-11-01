(defproject deps-ancient "0.0.2"
  :description "A small tool wrapping ancient-clj for checking if your deps.edn deps are ancient"
  :url "https://github.com/slipset/deps-ancient"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[ org.clojure/clojure "1.10.0-RC1"]
                 [ancient-clj "0.6.15"]]
  :deploy-repositories [["clojars" {:url "https://clojars.org/repo"
                                  :username :env/clojars_username
                                  :password :env/clojars_password
                                  :sign-releases false}]])

