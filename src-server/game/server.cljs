(ns ^:figwheel-always game.server
  (:require [cljs.nodejs :as nodejs]
            [game.page :as page]))

(defn debug[]
  (nodejs/enable-util-print!))

(defn setup[]
  (defonce express (nodejs/require "express"))
  (defonce serve-static (nodejs/require "serve-static"))
  (defonce http (nodejs/require "http"))

  (def app (express))

  (defn render-game[req res]
    (.send res (page/render-page (.-path req))))

  (. app (get "/" render-game))
  (. app (get "/memtest/" render-game))
  (. app (use (serve-static "resources/public/js/client")))
  (. app (use (serve-static "resources/public/static"))))

; main
(defn -main []
  (doto 
    (.createServer http #(app %1 %2))
    (.listen 3002 (fn [] 
                    (println "Server started on port 3002")))))

(debug)
(setup)
(set! *main-cli-fn* -main)
