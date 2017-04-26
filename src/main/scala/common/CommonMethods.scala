package common

import annotation.Contents
import classes.{BottleBox, ChildBottle}

import reflect.runtime.{universe => u}
import reflect.runtime.universe._

/**
  * Created by hanseung on 2017-04-21.
  */
object CommonMethods {

  def classAnnotation = {
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
    // 해당 클래스의 'Type' 을 이용하여 constructor, method, field 추출
    val extractMembers = u.typeOf[BottleBox].members.collect { case s: TermSymbol => s}
    extractMembers.foreach(println)
  }

  def getAnnotationArgs(annotationName: String) = { // TODO : Annotation class를 find 하는 방법 찾아야 함
    val extractMembers = u.typeOf[BottleBox].decls.collect { case s: TermSymbol => s}
    val annotations = extractMembers.flatMap(_.annotations)

    println("annotations.size : " + annotations.size)
    annotations.withFilter(_.tree.tpe.typeSymbol.name.toString == annotationName).foreach { l =>
      l.tree.children.tail.foreach { ii =>
        println("Annotation : " + l + ", Args : " + ii)
      }
    }
  }

  def listProperties[T: TypeTag] = {
    val fields = typeOf[T].decls.collect { case s: TermSymbol => s}
      .filter(s => s.isVal || s.isVar || s.isMethod)

    println("fields.size : " + fields.size)

    fields.flatMap { f =>
      f.annotations.find(_.tree.tpe =:= typeOf[Contents])
        .map((f, _)).toList
    }
  }

  def printListProperties = {
    println("listProperties[BottleBox].size : " + listProperties[BottleBox].size)
    listProperties[BottleBox].foreach { l =>
      println("TermSymbol : " + l._1 + ", annotation : " + l._2)
    }
    println("-----------------------------------------------------------------------------")
    println("list : " + listProperties[BottleBox])
  }

  def checkSymbol = {

  }

  def checkType = {
    val bottleBoxType: u.Type = typeOf[BottleBox] // initiating with typeOf method
    val childBottleType: u.Type = typeOf[ChildBottle]

    val intType = u.definitions.IntTpe // standard initiation

    println("-- Subtyping relationship ----------------------------")
    println("bottleBoxType <:< childBottleType : " + (bottleBoxType <:< childBottleType)) // Type을 이용하여 subtype check 가능
    println("childBottleType <:< bottleBoxType : " + (childBottleType <:< bottleBoxType))

    println("typeOf[Int] weak_<:< typeOf[Double] : " + (typeOf[Int] weak_<:< typeOf[Double])) // true
    println("typeOf[Double] weak_<:< typeOf[Int] : " + (typeOf[Double] weak_<:< typeOf[Int])) // false

    println("-- Type Equality -------------------------------------")
    println("bottleBoxType =:= typeOf[BottleBox] : " + (bottleBoxType =:= typeOf[BottleBox]))

    println("-- members -------------------------------------")
    bottleBoxType.members.foreach(println) // 해당 class에 직접 선언된 member들 + 상속받은 member들
    println("-- declarations -------------------------------------")
    bottleBoxType.decls.foreach(println) // 해당 class에 직접 선언된 member들

    println("-- comparing member and decl -------------------------------------")
    println("bottleBoxType.member(\"toString\": TermName) : " + bottleBoxType.member("toString": TermName))
    println("bottleBoxType.decl(\"toString\": TermName) : " + bottleBoxType.decl("toString": TermName))

  }

  def checkTree = {

  }
}
