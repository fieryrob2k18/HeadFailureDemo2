package view

import play.api.libs.json.{JsValue, Json}

class Game {

  // Do not change these state variable names, types, or initial values
  //
  // These same names, types, and initial values will be the same in all submissions on AutoLab so you can
  //  use these in your test cases
  var gold: Double = 0.0
  var currentWinner: String = ""
  var lastUpdateTime: Long = System.nanoTime()
  var equipment: Map[String, Users] = Map("shovel" -> new User2, "excavator" -> new User1, "mine" -> new User3)
  //

  def goldPerSecond(): Double = {
  0.0
  }
  def goldPerClick(): Double = {
  0.0
  }

  def clickGold(): Unit = {
//    this.gold += goldPerClick()
  }

  def buyEquipment(equipmentKey: String): Unit = {
    var equip = equipment(equipmentKey)
    if (gold >= equip.costOfNextPurchase()){
      this.gold= gold - equip.costOfNextPurchase()
      equip.buy()
    }
  }
  def update(time: Long): Unit = {
    var timeAway = (time - lastUpdateTime)/math.pow(10,9)
    this.gold += goldPerSecond() * timeAway
    this.lastUpdateTime = time
  }
  def toJSON(): String = {
    val jsGold: JsValue= Json.toJson(gold)
    val jsLastTime: JsValue = Json.toJson(lastUpdateTime)

    val numShov: JsValue = Json.toJson(equipment("shovel").numberOwned)
    val nameShov: JsValue = Json.toJson(equipment("shovel").name)
    val shovel: Map[String, JsValue]= Map(
      "numberOwned" -> numShov,
      "name" -> nameShov
    )
    val shovel1: JsValue= Json.toJson(shovel)

    val numExc: JsValue = Json.toJson(equipment("excavator").numberOwned)
    val nameExc: JsValue = Json.toJson(equipment("excavator").name)
    val excavator: Map[String, JsValue]= Map(
      "numberOwned" -> numExc,
      "name" -> nameExc
    )
    val excavator1: JsValue= Json.toJson(excavator)

    val numMine: JsValue = Json.toJson(equipment("mine").numberOwned)
    val nameMine: JsValue = Json.toJson(equipment("mine").name)
    val mine: Map[String, JsValue]= Map(
      "numberOwned" -> numMine,
      "name" -> nameMine
    )
    val mine1: JsValue= Json.toJson(mine)

    val equipMap: Map[String, JsValue]= Map(
      "shovel" -> shovel1,
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

    val shovel: JsValue= (equip \ "shovel").as[JsValue]
    this.equipment("shovel").numberOwned = (shovel \ "numberOwned").as[Int]
    this.equipment("shovel").name = (shovel \ "name").as[String]

    val excavator: JsValue=(equip \ "excavator").as[JsValue]
    this.equipment("excavator").numberOwned = (excavator \ "numberOwned").as[Int]
    this.equipment("excavator").name = (excavator \ "name").as[String]

    val mine: JsValue = (equip \"mine").as[JsValue]
    this.equipment("mine").numberOwned = (mine \ "numberOwned").as[Int]
    this.equipment("mine").name = (mine \ "name").as[String]

  }
  /**
    * takes the current epoch time in nanoseconds
    */



  // Given
  def goldString(): String = {
    f"$gold%1.0f"
  }

  def buttonText(equipmentKey: String): String = {
    val thing: Users = this.equipment.getOrElse(equipmentKey, null) // will crash program if key not found
    val cost = thing.costOfNextPurchase()
    val gpc = thing.goldPerClick()
    val gps = thing.goldPerSecond()
    f"\nthis will be a comment\nUsername \nPoints: " + thing.numberOwned
  }

  //

}
