package tests

import org.scalatest._
import model.gameRules
import model.Player
import model.Card

class BackEndTest extends FunSuite {

  test("Czar Test"){
    gameRules.players = List(new Player("Tom"), new Player("Rick"), new Player("Harry"))
    assert(gameRules.czarIndex == 0)
    gameRules.czarTurn()
    gameRules.czarTurn()
    assert(gameRules.czarIndex==2 && gameRules.players.apply(2).isCzar == true)
    gameRules.czarTurn()
    assert(gameRules.czarTurn()==0 && gameRules.players.apply(0).isCzar == true)
  }

  test("Cards Test"){
    gameRules.players = List(new Player("Bill"))
    gameRules.players.apply(0).cards = List(new Card("sample",gameRules.players.apply(0)), new Card("Text",gameRules.players.apply(0)))
    gameRules.submittedCards(gameRules.players.apply(0).cards.apply(0))
    assert(gameRules.cardsPlayed.length == 1 && gameRules.players.apply(0).cards.length == 1)
  }

}
