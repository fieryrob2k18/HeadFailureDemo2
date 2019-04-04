package GameYourMeme.users


import scala.util.Random

class Player(val name: String) {
  var cards: List[Card] = List()
  var isCzar: Boolean = false

  def addWhiteCards(captions: List[String], amountOfCards: Int): Unit ={
    var i = 0
    while(i < amountOfCards){
      val randomNum: Int = Random.nextInt(captions.length - 1)
      this.cards = this.cards :+ new Card(captions(randomNum), this)
      i+=1
    }
  }

  def cardSelected(submitted: Card): Unit ={
    var newCards: List[Card] = List()
    for(i <- this.cards){
      if(i.caption != submitted.caption){
        newCards = newCards :+ i
      }
    }
    this.cards = newCards
  }
}