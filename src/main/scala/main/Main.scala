package main

import common.CommonMethods._

/**
  * Created by hanseung on 2017-04-26.
  */
object Main extends App {
  override def main(args: Array[String]): Unit = {

//    println("== Class Annotation ========================================================================")
//    classAnnotation
//
//    println("== Class Members ===========================================================================")
//    extractMembers
//
//    println("== List Properties =========================================================================")
//    printListProperties

    println("== Annotation Args =========================================================================")
    getAnnotationArgs("Contents")

    println("== Check Symbol ============================================================================")
    checkSymbol
  }
}
