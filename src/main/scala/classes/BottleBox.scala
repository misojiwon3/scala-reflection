package classes

import annotation.{Bottle, Contents}

/**
  * Created by hanseung on 2017-04-21.
  */

@Bottle(10000)
class BottleBox extends ParentBottle {

  @Contents("Nestle", "water")
  def waterBottle = Unit

  @Contents("CocaCola", "coke")
  val cokeBottle = Unit

  @Contents("Sunkist", "juice")
  var juiceBottle = Unit
}