(ns bronen.reaclj-spec
  {:dev/always true}
  (:require [cljs.test :refer (deftest is)]))

(deftest a-failing-test
  (is (= 1 0)))
