(defproject clojure-game "0.1.0-SNAPSHOT"
  :description "Clojure RPG"
  :url "https://github.com/jomei/clojure_game"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot game.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
