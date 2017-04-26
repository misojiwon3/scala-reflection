import classes.{BottleBox, ChildBottle}

import scala.reflect.runtime.{universe => ru}
import scala.reflect.runtime.universe._

println("== Types ========")

typeOf[BottleBox]

ru.definitions.IntTpe

ru.definitions // reflection이 지원하는 모든 타입 지정 가능

typeOf[ChildBottle]

typeOf[BottleBox]

typeOf[NoneClass]

//bottleBox <:< childBottle

println("== Runtime Mirror ========")

val mirror = ru.runtimeMirror(getClass.getClassLoader)

val instanceMirror = mirror.reflect(new BottleBox)

println("auth : " + instanceMirror)

val generalSampleMethod: ru.Symbol = ru.typeOf[BottleBox].decl(ru.TermName("waterBottle"))

val sampleMethod: ru.MethodSymbol = ru.typeOf[BottleBox].decl(ru.TermName("waterBottle")).asMethod

val methodMirror: ru.MethodMirror = instanceMirror.reflectMethod(sampleMethod)

sampleMethod.fullName

sampleMethod.annotations.foreach(println)

val sampleField: ru.TermSymbol = ru.typeOf[BottleBox].decl(ru.TermName("cokeBottle")).asTerm.accessed.asTerm

val fieldMirror: ru.FieldMirror = instanceMirror.reflectField(sampleField)

val sampleClass: ru.ClassSymbol = ru.typeOf[BottleBox].typeSymbol.asClass

//val classMirror: ru.ClassMirror = instanceMirror.reflectClass(sampleClass)


val clazz: Class[BottleBox] = classOf[BottleBox]

val fields = clazz.getFields // 해당 class의 field들을 인식할 수 없음.

fields.foreach(println)

println("checker")