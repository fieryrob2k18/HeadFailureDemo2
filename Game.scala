package GameYourMeme

import GameYourMeme.users._
import play.api.libs.json.{JsValue, Json}

import scala.util.Random

class Game {

  var gold: Double = 0.0
  var currentWinner: String = ""
  var lastUpdateTime: Long = System.nanoTime()
  val c: Int = scala.io.StdIn.readInt()
  var equipment: Map[String, Users] = Map()
  if (c == 3){
    equipment = Map(
      "User1" -> new User1,
      "User2" -> new User2,
      "User3" -> new User3
    )
  }
  else if (c == 4){
    equipment = Map(
      "User1" -> new User1,
      "User2" -> new User2,
      "User3" -> new User3,
      "User4" -> new User4
    )
  }
  else if (c ==5){
    equipment = Map(
      "User1" -> new User1,
      "User2" -> new User2,
      "User3" -> new User3,
      "User4" -> new User4,
      "User5" -> new User5
    )
  }
  else if (c ==6){
    equipment = Map(
      "User1" -> new User1,
      "User2" -> new User2,
      "User3" -> new User3,
      "User4" -> new User4,
      "User5" -> new User5,
      "User6" -> new User6
    )
  }
  else if (c ==7){
    equipment = Map(
      "User1" -> new User1,
      "User2" -> new User2,
      "User3" -> new User3,
      "User4" -> new User4,
      "User5" -> new User5,
      "User6" -> new User6,
      "User7" -> new User7
    )
  }
  else if (c ==8){
    equipment = Map(
      "User1" -> new User1,
      "User2" -> new User2,
      "User3" -> new User3,
      "User4" -> new User4,
      "User5" -> new User5,
      "User6" -> new User6,
      "User7" -> new User7,
      "User8" -> new User8
    )
  }
  var equipment1: Map[String, Users] = Map()
  if (c == 3){
    equipment1 = Map(
      "User1" -> new User1,
      "User2" -> new User2,
      "User3" -> new User3
    )
  }
  else if (c == 4){
    equipment1 = Map(
      "User1" -> new User1,
      "User2" -> new User2,
      "User3" -> new User3,
      "User4" -> new User4
    )
  }
  else if (c ==5){
    equipment1 = Map(
      "User1" -> new User1,
      "User2" -> new User2,
      "User3" -> new User3,
      "User4" -> new User4,
      "User5" -> new User5
    )
  }
  else if (c ==6){
    equipment1 = Map(
      "User1" -> new User1,
      "User2" -> new User2,
      "User3" -> new User3,
      "User4" -> new User4,
      "User5" -> new User5,
      "User6" -> new User6
    )
  }
  else if (c ==7){
    equipment1 = Map(
      "User1" -> new User1,
      "User2" -> new User2,
      "User3" -> new User3,
      "User4" -> new User4,
      "User5" -> new User5,
      "User6" -> new User6,
      "User7" -> new User7
    )
  }
  else if (c ==8){
    equipment1 = Map(
      "User1" -> new User1,
      "User2" -> new User2,
      "User3" -> new User3,
      "User4" -> new User4,
      "User5" -> new User5,
      "User6" -> new User6,
      "User7" -> new User7,
      "User8" -> new User8
    )
  }

  var cardList: List[String] = List("a","b","c","d","e","f","g","h","i","j")
//  if (cardList.length < 10){
//    val randomNum: Int = Random.nextInt()
//    this.cardList = this.cardList :+ new Card(captions(randomNum), this)
//  }

  def buyEquipment(equipmentKey: String): Unit = {
    val equip = equipment(equipmentKey)
    equip.addPoint()
  }
  def update(time: Long): Unit = {
    this.lastUpdateTime = time
  }
  def toJSON: String = {
    val jsGold: JsValue= Json.toJson(gold)
    val jsLastTime: JsValue = Json.toJson(lastUpdateTime)

    val numShov: JsValue = Json.toJson(equipment("User1").pointCount)
    val nameShov: JsValue = Json.toJson(equipment("User1").name)
    val user1: Map[String, JsValue]= Map(
      "numberOwned" -> numShov,
      "name" -> nameShov
    )
    val user11: JsValue= Json.toJson(user1)

    val numExc: JsValue = Json.toJson(equipment("User2").pointCount)
    val nameExc: JsValue = Json.toJson(equipment("User2").name)
    val excavator: Map[String, JsValue]= Map(
      "numberOwned" -> numExc,
      "name" -> nameExc
    )
    val excavator1: JsValue= Json.toJson(excavator)

    val numMine: JsValue = Json.toJson(equipment("User3").pointCount)
    val nameMine: JsValue = Json.toJson(equipment("User3").name)
    val mine: Map[String, JsValue]= Map(
      "numberOwned" -> numMine,
      "name" -> nameMine
    )
    val mine1: JsValue= Json.toJson(mine)

    val equipMap: Map[String, JsValue]= Map(
      "shovel" -> user11,
      "excavator" -> excavator1,
      "mine" -> mine1
    )
    val totalMap: JsValue= Json.toJson(equipMap)

    val jsMap: Map[String, JsValue]= Map(
      "gold" -> jsGold,
      "lastUpdateTime" -> jsLastTime,
      "equipment" -> totalMap
    )
    Json.stringify(Json.toJson(jsMap))
  }

  def fromJSON(jsonGameState: String): Unit = {
    val state = jsonGameState
    val parsed: JsValue = Json.parse(state)
    this.gold = (parsed\ "gold").as[Double]
    this.lastUpdateTime = (parsed \ "lastUpdateTime").as[Long]

    val equip: JsValue= (parsed \ "equipment").as[JsValue]

    val shovel: JsValue= (equip \ "User1").as[JsValue]
    this.equipment("User1").pointCount = (shovel \ "numberOwned").as[Int]
    this.equipment("User1").name = (shovel \ "name").as[String]

    val excavator: JsValue=(equip \ "User2").as[JsValue]
    this.equipment("User2").pointCount = (excavator \ "numberOwned").as[Int]
    this.equipment("User2").name = (excavator \ "name").as[String]

    val mine: JsValue = (equip \"User3").as[JsValue]
    this.equipment("User3").pointCount = (mine \ "numberOwned").as[Int]
    this.equipment("User3").name = (mine \ "name").as[String]

  }

  def buttonText(equipmentKey: String): String = {
    val thing: Users = this.equipment.getOrElse(equipmentKey, null) // will crash program if key not found
    f"\nUsername \nPoints: " + thing.pointCount
  }
  def buttonText1(equipmentKey: String): String = {
    val thing: Users = this.equipment.getOrElse(equipmentKey, null) // will crash program if key not found
    f"\nrandom gibbersh" + thing.pointCount
  }

}
