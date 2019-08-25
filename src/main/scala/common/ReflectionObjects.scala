package common

import classes.Television
import common.CommonMethods.getClass

import scala.reflect.runtime.universe._
import scala.reflect.runtime.{universe => ru}

object ScalaReflection {

  val rm: ru.Mirror = ru.runtimeMirror(getClass.getClassLoader)

  def convertClassToString(className: Class[_]): ru.Type = rm.classSymbol(className).toType


  def getTreeFromClass(className: Class[_]): List[ru.Tree] = {
    val classType = convertClassToString(className)
    val classSymbol = classType.typeSymbol.asClass

    classSymbol.annotations.map(_.tree)
  }
}

object Traverser extends Traverser {
  var applies = List[Apply]()

  override def traverse(tree: Tree): Unit = tree match {
    case app@Apply(fun, args) =>
      println(s"fun $fun, args $args")
      applies = app :: applies
      super.traverse(fun)
      super.traverseTrees(args)
    case _ =>
      super.traverse(tree)
  }
}