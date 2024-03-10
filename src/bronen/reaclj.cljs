(ns bronen.reaclj)

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

(defn parseTextNode
  "Parses raw text into text content"
  [node]
  (let [frag (js/document.createDocumentFragment)]
    (-> frag (.-textContent) (set! node))
    frag))

(defn parseNode
  "Renders a Virtual DOM tree on the DOM"
  [vnode state setState]
  (let [node (vnode state setState)
        el (-> node :tag js/document.createElement)
        parseEl #(if (string? %) (parseTextNode %) (parseNode % state setState))]
    (mapv #(.appendChild el (parseEl %)) (:children node))
    (when (:on-click node)
      (-> el (.-onclick) (set! (:on-click node))))
    el))

(defn renderDOM
  "Renders a Virtual Node on the DOM"
  [target el initialstate]
  (let [elref (atom nil)
        state (atom initialstate)
        setState (fn [newState newSetState]
                   (.removeChild target @elref)
                   (reset! state newState)
                   (reset! elref (parseNode el state newSetState))
                   (.appendChild target @elref))] 
    (reset! elref (parseNode el state setState))
    (.appendChild target @elref)))

(defn ^:export init
  []
  (let [state {:name "initial" :counter 0}]
    (renderDOM
     (js/document.getElementById "root")
     helloworldComponent
     state)))
