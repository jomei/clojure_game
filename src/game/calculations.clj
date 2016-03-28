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
      (<= rd s) (int (/ base 2))
      (= rd s) (* base 2)
      (> rd s) (base)
      )
    ))

(defn cast-to-zero [n]
  (if (neg? n) 0 n))

(defn base-damage [attack attack]
  (- attack defence))

(defn dice-sides [lvl]
  (if (> lvl 5) 4 6))


(defn take-dmg [from to]
  (let [bdmg (base-damage (:attack from) (:defence to))
        sides (dice-sides (:lvl from))
        rdmg (real-dmg bdmg sides)]
    [rdmg (update-in to :hp #(- % rdmg))])
  )
