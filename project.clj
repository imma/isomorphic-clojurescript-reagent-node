(defproject demo "0.1.0-SNAPSHOT"
  :description "Demo to show how to build an isomorphic app with CLJS"
  :url "http://defn.sh/isomorphic-clojurescript-reagent-node"

  :min-lein-version "2.6.1"

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.8.40"]
                 [reagent "0.6.0-alpha"]
                 [secretary "1.2.3"]
                 [kibu/pushy "0.3.6"]]

  :plugins [[lein-cljsbuild "1.1.2"]]

  :source-paths ["src"]

  :clean-targets ^{:protect false} ["resources"]

  :cljsbuild {
    :builds [{:id "server"
              :source-paths ["src" "src-server"]
              :compiler {
                :output-to "resources/public/js/server/server.js"
                :output-dir "resources/public/js/server"
                :optimizations :none
                :source-map true
                :main demo.server
                :target :nodejs}}
             {:id "client"
              :source-paths ["src" "src-client"]
              :compiler {
                :output-to "resources/public/js/client/client.js"
                :output-dir "resources/public/js/client"
                :optimizations :none
                :source-map true}}]})
