(ns demo.core
  (:require [reagent.core :as reagent :refer [atom]]
            [secretary.core :as secretary :refer-macros [defroute]]
            [memtest.core :as memtest]))

(def current-page (atom nil))

(defn no-game []
  (fn []
    [:p "Select a game ^^"]))

(defn home-page 
  ([] 
   (home-page no-game))
  ([game]
   (fn []
     [:div
      [:div 
       [:a {:href "/"} "Game Menu:"]
       [:span {:style {:padding "5px"}}]

       [:a {:href "/memtest"} "Memtest"]
       [:span {:style {:padding "5px"}}]

       [game]]])))

(defn app-view []
  [:div [@current-page]])

;-----------------------------------------------------------------------------------------------

(secretary/set-config! :prefix "/")

(defroute "/" []
  (.log js/console "home-page")
  (reset! current-page home-page))

(defroute "/memtest" []
  (.log js/console "memtest/memtest-page")
  (memtest/new-game)
  (reset! current-page (home-page memtest/memtest-page)))

; the server side doesn't have history, so we want to make sure current-page is populated
(reset! current-page home-page)
