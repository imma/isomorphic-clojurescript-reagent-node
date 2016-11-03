(ns game.client
  (:require [reagent.core :as reagent]
            [secretary.core :as secretary]
            [pushy.core :as pushy]
            [game.core :as game])
  (:import goog.History))

(enable-console-print!)

(reagent/render-component [game/app-view] (.getElementById js/document "app"))

(def history
  (pushy/push-state! secretary/dispatch!
    (fn [x] (when (secretary/locate-route x) x))))

(pushy/start! history)
