(defproject game "0.1.0-SNAPSHOT"
  :description "Demo to show how to build an isomorphic app with CLJS"
  :url "http://defn.sh/isomorphic-clojurescript-reagent-node"

  :dependencies [[org.clojure/clojurescript "1.9.293"]
                 [reagent "0.6.0"]
                 [secretary "1.2.3"]
                 [kibu/pushy "0.3.6"]]

  :plugins [[lein-cljsbuild "1.1.4"]
            [lein-figwheel "0.5.8"]]

  :clean-targets ^{:protect false} ["resources/public/server"
                                    "resources/public/client"]

  :cljsbuild {
    :builds [{:id "server"
              :source-paths ["src" "src-server"]
              :figwheel true
              :compiler {
                :asset-path "resources/public/server/js"
                :output-to "resources/public/server/js/server.js"
                :output-dir "resources/public/server/js"
                :optimizations :none
                :source-map true
                :main game.server
                :target :nodejs }}
             {:id "client"
              :source-paths ["src" "src-client"]
              :figwheel true
              :compiler {
                :asset-path "resources/public/client/js"
                :output-to "resources/public/client/js/client.js"
                :output-dir "resources/public/client/js"
                :optimizations :none
                :source-map true }}]}
  
  :figwheel { 
    :css-dirs ["resources/public/static/css" ] })

