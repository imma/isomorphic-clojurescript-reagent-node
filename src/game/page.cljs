(ns game.page
  (:require [reagent.core :as reagent]
            [secretary.core :as secretary :refer-macros [defroute]]
            [game.core :as game]))

(enable-console-print!)

;<html>
;  <head>
;    <meta charset="utf-8"/>
;    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
;    <link href="/css/site.css" rel="stylesheet" type="text/css"/>
;  </head>
;  <body>
;    <div id="app"/>
;    <script type="text/javascript" src="/js/bundle.js"></script>
;    <script type="text/javascript" src="/js/goog/base.js"></script>
;    <script type="text/javascript" src="/js/client.js"></script>
;    <script type="text/javascript">goog.require('game.client');</script>
;  </body>
;</html>

(defn template [{:keys [body]}]
  [:html
   [:head
    [:meta {:charset "utf-8"}]
    [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0"}]
    [:link {:href "/css/site.css" :rel "stylesheet" :type "text/css"}]]
   [:body
    [:div#app [body]]
    [:script {:type "text/javascript" :src "/js/bundle.js"}]
    [:script {:type "text/javascript" :src "/js/goog/base.js"}]
    [:script {:type "text/javascript" :src "/js/client.js"}]
    [:script {:type "text/javascript"
              :dangerouslySetInnerHTML {:__html "goog.require('game.client');"}}]]])

(defn ^:export render-page [path]
  (reagent/render-to-static-markup 
    (do
      (secretary/dispatch! path)
      [template {:body game/app-view}])))

