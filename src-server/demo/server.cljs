(ns demo.server
  (:require [cljs.nodejs :as nodejs]
            [demo.tools :as tools]))

(nodejs/enable-util-print!)

(defonce express (nodejs/require "express"))
(defonce serve-static (nodejs/require "serve-static"))
(defonce http (nodejs/require "http"))

(def app (express))

(. app (get "/" 
            (fn [req res] (.send res (tools/render-page (.-path req))))))
(. app (use (serve-static "resources/public/js/client")))
(. app (use (serve-static "resources/public/static")))

(defn -main []
  (doto 
    (.createServer http #(app %1 %2))
    (.listen 3002 (fn [] 
                    (println "Server started on port 3002")))))

(set! *main-cli-fn* -main)
