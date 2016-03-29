# Clojure Game
Let's do some clojure training!

## How to play
1. `lein repl`
2. Start game with default configuration
  `(game config)`

## Config

Config is a hash with two fields *player* and *enemy*, each of them is a character.
To generate character run `(create-character "name" int-lvl)` e.g `(create-character "Foo" 12)`

You can make your own config with
```
(def config
  {
    :player (create-character "foo" 10)
    :enemy (create-character "bar" 9)
  })

```


Game have 3 predefined character *Jim Raynor*, *zergling* and *ultralisk*

Enjoy!
