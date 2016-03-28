(ns game.dice)

(defn roll [sides]
  "return random number from 1 to sides"
  (inc (rand-int sides)))


