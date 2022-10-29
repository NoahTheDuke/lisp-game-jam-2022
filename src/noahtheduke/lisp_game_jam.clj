; This Source Code Form is subject to the terms of the Mozilla Public
; License, v. 2.0. If a copy of the MPL was not distributed with this
; file, You can obtain one at https://mozilla.org/MPL/2.0/.

(ns noahtheduke.lisp-game-jam
  (:import
   (org.hexworks.zircon.api Functions SwingApplications)
   (org.hexworks.zircon.api.color ANSITileColor)
   (org.hexworks.zircon.api.data Position Size Tile)
   (org.hexworks.zircon.api.graphics Layer)
   (org.hexworks.zircon.api.uievent KeyCode KeyboardEventType))
  (:gen-class))

(def player-tile
  (.. (Tile/newBuilder)
      (withBackgroundColor ANSITileColor/BLACK)
      (withForegroundColor ANSITileColor/WHITE)
      (withCharacter \@)
      (buildCharacterTile)))

(defn -main
  [& _args]
  (let [tile-grid (SwingApplications/startTileGrid)
        layer (.. (Layer/newBuilder)
                  (withSize (Size/one))
                  (withOffset (Position/create (/ (.getWidth tile-grid) 2) (/ (.getHeight tile-grid) 2)))
                  (withFiller player-tile)
                  (build))
        player (. tile-grid addLayer layer)]

    (. tile-grid
       processKeyboardEvents
       KeyboardEventType/KEY_PRESSED
       (Functions/fromBiConsumer
         (reify java.util.function.BiConsumer
           (accept [_this event _phase]
             (prn event)
             (condp = (.getCode event)
               KeyCode/UP (. player moveUpBy 1)
               KeyCode/DOWN (. player moveDownBy 1)
               KeyCode/LEFT (. player moveLeftBy 1)
               KeyCode/RIGHT (. player moveRightBy 1))))))))
