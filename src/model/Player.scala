package model

import scala.util.Random

class Player(val name: String) {
  var cards: List[String] = List()
  var isCzar: Boolean = false

  def addWhiteCards(captions: List[String], amountOfCards: Int): Unit ={
    this.cards = Random.shuffle(captions).take(amountOfCards)
  }
}
