package model

import scala.io.{BufferedSource, Source}
import scala.util.Random

object gameRules {

  var previousCzar: Int = 0

  def main(args :Array[String]): Unit ={
    var i = 0
    val list = List("Dan", "Jon", "Dave")
    val images = file_to_list("/model/game/imageFileNames")
    val captions = file_to_list("/model/game/captions")

    println(images)
    println("^ List of all image files\n")
    println(captions)
    println("^ List of all Captions\n")

    val hand_of_cards = getWhiteCards(captions)
    val imageCard = getImageFile(images)

    println(hand_of_cards)
    println("^ Specifically 10 cards in the players hand\n")
    println(imageCard)
    println("^ The single Image card supplied each round\n")

    while(i < 15){
      println(czarTurn(list))
      i += 1
    }
  }

  def file_to_list(filename: String): List[String] ={
    val file: BufferedSource = Source.fromFile(filename)
    var parsed: List[String] = List()

    for(line <- file.getLines()){
      val cap: Array[String] = line.split(":")
      parsed = cap(1) :: parsed
    }
    parsed
  }

  def getWhiteCards(captions: List[String]): List[String] ={
    val cards = Random.shuffle(captions).take(10)
    cards
  }

  def getImageFile(images: List[String]): String ={
    val image = Random.shuffle(images).take(1)
    image(0)
  }

  def czarTurn(players: List[String]): String={
    if(this.previousCzar >= players.length - 1) {
      this.previousCzar = 0
    }
    else{
      this.previousCzar = this.previousCzar + 1
    }
      players(this.previousCzar)
  }

}
