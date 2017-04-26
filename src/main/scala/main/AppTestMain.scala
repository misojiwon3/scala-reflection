package main

import common.CommonMethods._

/**
  * Created by hanseung on 2017-04-26.
  */
object AppTestMain extends App {
  override def main(args: Array[String]): Unit = {
    println("====================> start main")
    println("additional log")
    classAnnotation
    extractMembers
    extractAnnotationArgs
    printListProperties
  }
}
