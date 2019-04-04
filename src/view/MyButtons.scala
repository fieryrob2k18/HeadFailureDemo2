package view

import scalafx.Includes._
import scalafx.event.ActionEvent
import scalafx.scene.control._
import scalafx.scene.image.{Image, ImageView}
import model._

class MyButton(game: Game, xScale: Double, yScale: Double) extends Button {

  minWidth = 100 * xScale
  minHeight = 100 * yScale
  style = "-fx-font: 12 ariel;"

}

class Picture(game: Game, xScale: Double = 1.0, yScale: Double = 1.0) extends MyButton(game, xScale, yScale) {
  gameRules.getImageFile(gameRules.file_to_list("model/game/imageFileNames"))
  graphic = new ImageView(new Image (this, gameRules.image))
  style = "-fx-font: 24 ariel;"
  disarm()
}


class BuyEquipmentButton(val equipmentKey: String, game: Game, xScale: Double = 1.0, yScale: Double = 1.0) extends MyButton(game, xScale, yScale) {
  onAction = (event: ActionEvent) => game.buyEquipment(equipmentKey)
}

class BuyEquipmentButton1(val equipmentKey: String, game: Game, xScale: Double = 1.0, yScale: Double = 1.0) extends MyButton(game, xScale, yScale) {
  disarm()
}
