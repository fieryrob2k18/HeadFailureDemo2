package tests

import org.scalatest._
import model.gameRules
import model.Player
import model.Card

class BackEndTest extends FunSuite {

  test("Czar Test"){
    var gameRules = new gameRules
    gameRules.players = List(new Player("Tom"), new Player("Rick"), new Player("Harry"))
    gameRules.players.apply(0).isCzar = true
    assert(gameRules.czarIndex == 0)
    gameRules.czarTurn()
    gameRules.czarTurn()
    assert(gameRules.czarIndex==2 && gameRules.players.apply(2).isCzar == true)
    gameRules.czarTurn()
    assert(gameRules.czarIndex==0 && gameRules.players.apply(0).isCzar == true && gameRules.players.apply(2).isCzar == false)
  }

  test("Cards Test"){
    var gameRules = new gameRules
    gameRules.players = List(new Player("Bill"))
    gameRules.players.apply(0).cards = List(new Card("sample",gameRules.players.apply(0)), new Card("Text",gameRules.players.apply(0)))
    gameRules.submittedCards(gameRules.players.apply(0).cards.apply(0))
    assert(gameRules.cardsPlayed.length == 1 && gameRules.players.apply(0).cards.length == 1)
  }

}
