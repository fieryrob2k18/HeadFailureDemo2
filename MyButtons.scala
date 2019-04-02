package GameYourMeme.gui

import java.awt.Graphics
import java.awt.Image
import java.awt.image.BufferedImage
import java.io.File

import javax.imageio.ImageIO
import javax.imageio.ImageIO
import java.io.FileNotFoundException
import java.nio.file.{Files, Paths}

import GameYourMeme.Game
import scalafx.Includes._
import scalafx.event.ActionEvent
import scalafx.scene.control.Button
import scalafx.scene.image
import scalafx.scene.image.ImageView

import scala.io.Source

class MyButton(game: Game, xScale: Double, yScale: Double) extends Button {

  minWidth = 100 * xScale
  minHeight = 100 * yScale
  style = "-fx-font: 12 ariel;"

}

class Picture(game: Game, xScale: Double = 1.0, yScale: Double = 1.0) extends MyButton(game, xScale, yScale) {
//  var img = ImageIO.read("C:\Users\thewr\IdeaProjects\CSE116-Scala-Examples12\src\clicker\gui\run.jpg")
  text = "This is going to be an Image"
  style = "-fx-font: 24 ariel;"
  disarm()
}


class BuyEquipmentButton(val equipmentKey: String, game: Game, xScale: Double = 1.0, yScale: Double = 1.0) extends MyButton(game, xScale, yScale) {
  onAction = (event: ActionEvent) => game.buyEquipment(equipmentKey)
}
