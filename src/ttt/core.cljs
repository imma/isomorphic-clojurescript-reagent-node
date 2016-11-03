(ns ttt.core
  (:require [reagent.core :as reagent :refer [atom]]))

;-- the tic-tac-toe game ---------------------------------------------------------------------------

(def colors ; colors match the cell number
  {1 "#677685", 2 "#FFB492", 3 "#8EE6CA", 4 "#92387E",
   5 "#FFF6C9", 6 "#5C58EB", 7 "#D1052D", 8 "#857A67"})

(def counter (atom 0))              ; generates unique ids for each cell
(def gameboard (atom (sorted-map))) ; gameboard is sorted to preserve cell order

(defn add-cell [n]
  ; add a numbered cell with a unique id
  (let [id (swap! counter inc)]
    (swap! gameboard 
           assoc id {:id id 
                     :number n 
                     :color (colors n)})))

(defn new-game 
  []
  (.log js/console "new-game")
  (reset! counter 0)
  (reset! gameboard (sorted-map))
  (doseq [cell (shuffle (into (range 1 10)))]
    (add-cell cell)))

(defn handle-click
  [{:keys [number id] :as cell}])

(defn board-cell []
  (fn [{:keys [number color id] :as cell}]
    [:td {:class "game-cell"
          :style {}
          :on-click #(handle-click cell)}]))

(defn board-row []
  (fn [row]
    [:tr
     (for [{:keys [id] :as cell} row]
       ^{:key id} [board-cell cell])]))

(defn ttt-page []
  (fn []
    (let [cells (vals @gameboard)]
      [:div#container
       [:h1 "Tic Tac Toe"]
       [:p [:a {:class "new-game" 
                :on-click #(new-game)
                :href "#"} "New Game"]]
       [:table#gameboard [:tbody
        (map-indexed
          (fn [idx row] ^{:key idx} [board-row row])
          (partition 3 cells))]]])))
