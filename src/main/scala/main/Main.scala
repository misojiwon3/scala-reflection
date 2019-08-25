package main

import classes.Television
import common.ScalaReflection._
import common.Traverser

import scala.collection.immutable
import scala.reflect.runtime.universe

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
//
//    println("== Annotation Args =========================================================================")
//    getAnnotationArgs("Contents")
//
//    println("== Check Symbol ============================================================================")
//    checkSymbol()

    println("== Reflection Tree ============================================================================")
    val trees: immutable.Seq[universe.Tree] = getTreeFromClass(classOf[Television])

    trees.foreach { tree =>
      Traverser.traverse(tree)
      Traverser.applies.foreach(a => println(">> "+a))
    }

  }
}
