(ns game.core
  (:require [game.calculations :as calc]))

(defn create-character [name lvl]
  {
    :name name
    :lvl lvl
    :attack (calc/attack lvl)
    :defence (calc/defence lvl)
    :hp (calc/hp lvl)
    })


(def player (create-character "Jim Raynor" 10))
(def zergling (create-character "Crazy Dog" 3))
(def ultralisk (create-character "Your Mom" 9))

(:attack ultralisk)
(:defence player)
(calc/take-dmg ultralisk player)
(:hp player)
