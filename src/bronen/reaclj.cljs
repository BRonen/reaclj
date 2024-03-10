(ns bronen.reaclj)

(defn greet
  "Callable entry point to the application."
  []
  (js/console.log (str "Hello, Wworld!wwww")))

(defn ^:export init
  "I don't do a whole lot ... yet."
  []
  (greet))
