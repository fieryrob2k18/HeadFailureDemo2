
package users

import GameYourMeme.users.Player
import GameYourMeme.users.Card
import scala.io.{BufferedSource, Source}
import scala.util.Random

object gameRules {

  var czarIndex: Int = 0
  var image: String = ""
  var players: List[Player] = List()
  var cardsPlayed: List[Card] = List()


  def file_to_list(filename: String): List[String] ={
    val file: BufferedSource = Source.fromFile(filename)
    var parsed: List[String] = List()

    for(line <- file.getLines()){
      val cap: Array[String] = line.split(":")
      parsed = cap(1) :: parsed
    }
    parsed
  }


  def getImageFile(images: List[String]): Unit ={
    image = Random.shuffle(images).take(1).head
  }


  def czarTurn(): Unit ={
    if(czarIndex >= players.length - 1) {
      czarIndex = 0
    }
    else{
      czarIndex += 1
    }
    players(czarIndex).isCzar = true
  }

  def globalTimer(): Unit ={
    Thread.sleep(1000)
  }

  def submittedCards(received: Card): Unit ={
    cardsPlayed = cardsPlayed :+ received
    received.owner.cardSelected(received)
  }
}