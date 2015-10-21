(ns cider-test-error.core-test
  (:require [clojure.test :refer :all]))

(deftest test-1
  (throw (ex-info "bad error" {}))
  (is (= 1 1)))

(defn testdef-form [site-name]
  `(deftest ~(symbol (str site-name "-test"))
     (throw (ex-info "bad error" {}))
     (is (= 1 1))))

(defmacro defsite-tests []
  `(do
     ~@(map testdef-form ["a" "b"])))

(defsite-tests)
