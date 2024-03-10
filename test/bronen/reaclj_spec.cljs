(ns bronen.reaclj-spec
  {:dev/always true}
  (:require [cljs.test :refer (deftest is)]
            [bronen.reaclj :refer (greet)]))

(deftest a-failing-test
  (greet)
  (is (= 1 (- 2 1))))
