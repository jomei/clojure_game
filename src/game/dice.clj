(ns game.dice)

(defn roll
  "return random number from 1 to sides"
  [sides]
  (inc (rand-int sides)))


