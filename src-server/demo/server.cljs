(ns demo.server
  (:require [cljs.nodejs :as nodejs]
            [demo.tools :as tools]))

(nodejs/enable-util-print!)

(def express (nodejs/require "express"))
(def serve-static (nodejs/require "serve-static"))

(defn handle-request [req res]
 (.send res (tools/render-page (.-path req))))

(defn -main []
  (let [app (express)]
    (.get app "/" handle-request)
    (.use app (serve-static "resources/public/js/client"))
    (.use app (serve-static "resources/public/css"))
    (.use app (serve-static "resources/public/static"))
    (.listen app 3002 (fn []
                        (println "Server started on port 3002")))))

(set! *main-cli-fn* -main)
