(ns demo.core
  (:require [reagent.core :as reagent :refer [atom]]
            [secretary.core :as secretary :refer-macros [defroute]]
            [memtest.core :as memtest]
            [tictactoe.core :as tictactoe]))

(def current-page (atom nil))

(defn home-page []
  (fn []
    [:div 
      [:a {:href "/"} "Game Menu:"]
      [:span {:style {:padding "5px"}}]

      [:a {:href "/memtest"} "Memtest"]
      [:span {:style {:padding "5px"}}]

      [:a {:href "/tictactoe"} "Tic Tac Toe"]
      [:span {:style {:padding "5px"}}]
      ]))

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
  (reset! current-page memtest/memtest-page))

(defroute "/tictactoe" []
  (.log js/console "tictactoe/tictactoe-page")
  (tictactoe/new-game)
  (reset! current-page tictactoe/tictactoe-page))

; the server side doesn't have history, so we want to make sure current-page is populated
(reset! current-page home-page)

