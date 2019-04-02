package GameYourMeme.users


abstract class Users {

  var numberOwned: Int = 0
  var name: String = ""

  def goldPerSecond(): Double

  def goldPerClick(): Double

  def costOfNextPurchase(): Double

  def buy(): Unit =
    numberOwned +=1

}

