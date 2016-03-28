(ns game.calculations
  (:require [game.dice :as dice]))

(defn attack [lvl]
  "compute attack according to lvl by formula"
  (* lvl 2))

(defn defence [lvl]
  "compute attack according to lvl by formula"
  (int (* lvl 1.5)))

(defn hp [lvl]
  (* lvl 20))

(defn real-dmg [base sides]
  (let [rd (dice/roll sides)
         s (/ sides 2)]
    (cond
      (< rd s) (int (/ base 2))
      (= rd s) (* base 2)
      (> rd s) (base)
      )
    ))
