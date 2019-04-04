package view

import scalafx.animation.AnimationTimer
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.control.TextField
import scalafx.scene.effect.DropShadow
import scalafx.scene.layout.{GridPane, VBox}
import scalafx.scene.paint.Color.{Black, Gold, Goldenrod}
import scalafx.scene.paint.{LinearGradient, Stops}
import scalafx.scene.text.Text

object GUI extends JFXApp {



  val game = new Game()
  var currentWinner: TextField = new TextField {
    text = " Current Winner:()"
    editable = false
  }
  val screenShot = new Picture(game,2,2)
  val equipmentButtons1: List[BuyEquipmentButton1] = game.equipment1.map({ case (equipmentKey, _) => new BuyEquipmentButton1(equipmentKey, game) }).toList
  val equipmentButtons: List[BuyEquipmentButton] = game.equipment.map({ case (equipmentKey, _) => new BuyEquipmentButton(equipmentKey, game) }).toList

  this.stage = new PrimaryStage {
    title = "Game Your Meme!"
    scene = new Scene {
      fill = Black
      content = new VBox {
        children = Seq(
          new Text {
            text = "         Game Your Meme"
            style = "-fx-font-size: 48pt"
            fill = new LinearGradient(
              endX = 0,
              stops = Stops(Gold, Goldenrod)
            )
            effect = new DropShadow {
              color = Goldenrod
              radius = 25
              spread = 0.25
            }
          },
          new GridPane {
            add(screenShot, 0, 0, 2, 6)
            add(currentWinner, 5, 0)
            equipmentButtons.indices.foreach(i => add(equipmentButtons.apply(i), 6, i))
            equipmentButtons1.indices.foreach(i => add(equipmentButtons1.apply(i), 9, i))
          }
        )
      }
    }
        AnimationTimer(update).start()
  }
  def update(time: Long): Unit = {
    game.update(time)
    currentWinner.text = "Current Winner:"
    equipmentButtons.foreach(x => x.text = game.buttonText(x.equipmentKey))
    equipmentButtons1.foreach(x => x.text = game.buttonText1(x.equipmentKey))
  }


}
