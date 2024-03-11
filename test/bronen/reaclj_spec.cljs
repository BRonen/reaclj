(ns bronen.reaclj-spec)

(js/test "select filter"
         (fn []
           (-> (js/expect 2)
               (.-not)
               (.toBe 1))))