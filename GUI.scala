package GameYourMeme.gui

import GameYourMeme.Game
import scalafx.animation.AnimationTimer
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.control.TextField
import scalafx.scene.layout.GridPane
import scalafx.scene.paint.Color

object GUI extends JFXApp {


  val game = new Game()

  var goldDisplay: TextField = new TextField {
    text = " Current Winner"
    editable = false
    style = "-fx-font: 18 ariel;"

  }

  val digButton = new Picture(game, 2, 2)

  val equipmentButtons: List[BuyEquipmentButton] = game.equipment.map({ case (equipmentKey, _) => new BuyEquipmentButton(equipmentKey, game) }).toList

  this.stage = new PrimaryStage {
    title = "Game Your Meme!!"
    scene = new Scene() {
      fill = Color.rgb(38, 38, 38)
      content = List(
        new GridPane {
          add(digButton, 0, 0, 2, 2)
          add(goldDisplay, 5, 0)
          equipmentButtons.indices.foreach(i => add(equipmentButtons.apply(i), 6, i))
        }
      )
    }

    AnimationTimer(update).start()
  }

  def update(time: Long): Unit = {
    game.update(time)
    goldDisplay.text = "Current Winner:"+
    equipmentButtons.foreach(x => x.text = game.buttonText(x.equipmentKey))

  }


}