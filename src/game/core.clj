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

(def config
  {
    :player player
    :enemy ultralisk
    })

(def log-templete
  "Character %s recived %d damage.
Actual HP is %d"
  )

(defn print-battle-log [character damage]
  (let [name (:name character)
        hp (:hp character)
        s (format log-templete name damage hp)]
    (println s)))

(defn print-winner [player-hp enemy-hp]
  (if (>= player-hp enemy-hp)
    (println "Player won")
    (println "Enemy won")))

(defn game [config]
  (loop [player (:player config)
         enemy (:enemy config)
         round 1]
    (if (or (<= (:hp player) 0)
            (<= (:hp enemy) 0))
      (print-winner (:hp player) (:hp enemy))
      (let [pl->en (calc/take-dmg player enemy)
            en->pl (calc/take-dmg enemy player)]
        (do
          (println (str "Round " round ": "))
          (print-battle-log (pl->en 1) (pl->en 0))
          (print-battle-log (en->pl 1) (en->pl 0))
          (recur (en->pl 1) (pl->en 1) (inc round))
          )))))


