package common

import annotation.Contents
import classes.BottleBox

import

import reflect.runtime.{universe => u}
import reflect.runtime.universe._

/**
  * Created by hanseung on 2017-04-21.
  */
object CommonMethods {

  def classAnnotation = {
    println("== Class Annotation ========================================================================")
    val annotation = typeOf[BottleBox].typeSymbol.annotations.head
    val anno: u.ClassSymbol = u.typeOf[BottleBox].typeSymbol.asClass

    println("annotation1 : " + annotation)
    anno.annotations.foreach { a =>
      println("aa : " + a)
    }
    println("-----------------------------------------------------------------------------")
    u.symbolOf[BottleBox].annotations.foreach { annotation =>
      println("annotation : " + annotation)
    }
  }

  def extractMembers = {
    println("== Class Members ===========================================================================")
    // 해당 클래스의 constructor, method, field 추출
    val extractMembers = u.typeOf[BottleBox].members.collect { case s: TermSymbol => s}
    extractMembers.foreach(println)
  }

  def extractAnnotationArgs = { // TODO : Annotation class를 find 하는 방법 찾아야 함
    println("== Annotation Args ==========================================================================")
    val extractMembers = u.typeOf[BottleBox].members.collect { case s: TermSymbol => s}
    val annotations = extractMembers.flatMap(_.annotations)

    println("annotations.size : " + annotations.size)
    annotations.foreach { l =>
      l.tree.children.tail.foreach { ii =>
        println("Annotation : " + l + ", Args : " + ii)
      }
    }
  }

  def listProperties[T: TypeTag] = {
    val fields = typeOf[T].members.collect { case s: TermSymbol => s}
      .filter(s => s.isVal || s.isVar || s.isMethod)

    println("fields.size : " + fields.size)

    fields.flatMap { f =>
      f.annotations.find(_.tree.tpe =:= typeOf[Contents])
        .map((f, _)).toList
    }
  }

  def printListProperties = {
    println("-----------------------------------------------------------------------------")
    println("listProperties[BottleBox].size : " + listProperties[BottleBox].size)
    listProperties[BottleBox].foreach { l =>
      println("TermSymbol : " + l._1 + ", annotation : " + l._2)
    }
    println("-----------------------------------------------------------------------------")
    println("list : " + listProperties[BottleBox])
  }
}
