package GameYourMeme.users

import users.gameRules.{czarIndex, players}

class User1 extends Users {

  this.name = ""
  this.pointCount= 0
  var czarIndex: Int = 0

  override def czarTurn(): Unit={
    if(czarIndex >= players.length - 1) {
      czarIndex = 0
    }
    else{
      czarIndex += 1
    }
    players(czarIndex).isCzar = true
  }


}