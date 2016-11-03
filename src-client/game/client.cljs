(ns game.client
  (:require [reagent.core :as reagent]
            [secretary.core :as secretary]
            [pushy.core :as pushy]
            [game.core :as game])
  (:import goog.History))

(defn debug[]
  (enable-console-print!))

(debug)

(defn setup[]
  (reagent/render-component [game/app-view] (.getElementById js/document "app")))

(def history
  (pushy/push-state! secretary/dispatch!
    (fn [x] (when (secretary/locate-route x) x))))

; main
(defn -main[]
  (pushy/start! history))

(setup)
(-main)
