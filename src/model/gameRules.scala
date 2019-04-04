package model

import scala.io.{BufferedSource, Source}
import scala.util.Random

class gameRules {

  var czarIndex: Int = 0
  var image: String = ""
  var players: List[Player] = List()
  var cardsPlayed: List[Card] = List()


  def file_to_list(filename: String): List[String] ={
    val file: BufferedSource = Source.fromFile(filename)
    var parsed: List[String] = List()

    for(line <- file.getLines()){
      val cap: Array[String] = line.split(":")
      parsed = parsed :+ cap(1)
    }
    parsed
  }


  def getImageFile(images: List[String]): Unit ={
    image = Random.shuffle(images).take(1).head
  }


  def czarTurn(): Unit ={
    this.players.apply(czarIndex).isCzar = false
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
