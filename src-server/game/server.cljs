(ns ^:figwheel-always game.server
  (:require [cljs.nodejs :as nodejs]
            [game.page :as page]))

(defn debug[]
  (nodejs/enable-util-print!))

(debug)

(defonce express (nodejs/require "express"))
(defonce serve-static (nodejs/require "serve-static"))

(def app (express))

(defn render-game[req res]
  (.send res (page/render-page (.-path req))))

(defn setup[]
  (doto app
    (.use (serve-static "resources/public/static"))
    (.use (serve-static "resources/public/js/client"))
    (.use render-game)))

; main
(defn -main []
  (doto app
    (.listen 3002 (fn [] 
                    (println "Server started on port 3002")))))

(setup)
(set! *main-cli-fn* -main)
