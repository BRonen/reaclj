(ns bronen.example
  (:require [bronen.reaclj :refer (renderDOM)]))

(defn helloworldComponent
  [state setState]
  (let [examplename (:name @state)
        counter (:counter @state)]
    {:tag "p"
     :children ["wasdwasd"
                "wadawd"
                (str counter)
                (fn [_] {:tag "p"
                         :on-click (fn [] (setState {:name examplename :counter (+ counter 1)} setState))
                         :children [examplename]})]}))

(defn ^:export init
  []
  (let [state {:name "initial" :counter 0}]
    (renderDOM
     (js/document.getElementById "root")
     helloworldComponent
     state)))
