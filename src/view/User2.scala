package view

class User2 extends Users {
  var cost: Double = 10.0

  this.name = "User2"
  this.numberOwned =0

  override def goldPerClick(): Double = {
    0.0
  }

  override def goldPerSecond(): Double = {
    0.0
  }

  override def costOfNextPurchase(): Double = {
    0.0
  }
}