package view

import model.{Card, Player}


abstract class Users {
  var cards: List[Card] = List()
  var isCzar: Boolean = false
  var pointCount: Int = 0
  var name: String = ""
  var players: List[Player] = List()



  def addPoint(): Unit =
    pointCount +=1

  def addPlayer(): Unit =
    players :+ 1

//
//  def addWhiteCards(captions: List[String], amountOfCards: Int): Unit ={
//    var i = 0
//    while(i < amountOfCards){
//      val randomNum: Int = Random.nextInt(captions.length - 1)
//      this.cards = this.cards :+ new Card(captions(randomNum), this)
//      i+=1
//    }
//  }

  def cardSelected(submitted: Card): Unit ={
    var newCards: List[Card] = List()
    for(i <- this.cards){
      if(i.caption != submitted.caption){
        newCards = newCards :+ i
      }
    }
    this.cards = newCards
  }
  def czarTurn(): Unit ={
    isCzar == true
  }
}

