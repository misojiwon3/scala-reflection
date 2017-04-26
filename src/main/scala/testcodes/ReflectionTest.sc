import classes.BottleBox

import scala.reflect.runtime.{universe => ru}



val mirror = ru.runtimeMirror(getClass.getClassLoader)

val instanceMirror = mirror.reflect(new BottleBox)

println("auth : " + instanceMirror)

val sampleMethod: ru.MethodSymbol = ru.typeOf[BottleBox].decl(ru.TermName("waterBottle")).asMethod

val methodMirror: ru.MethodMirror = instanceMirror.reflectMethod(sampleMethod)

val sampleField: ru.TermSymbol = ru.typeOf[BottleBox].decl(ru.TermName("cokeBottle")).asTerm.accessed.asTerm

val fieldMirror: ru.FieldMirror = instanceMirror.reflectField(sampleField)

val sampleClass: ru.ClassSymbol = ru.typeOf[BottleBox].typeSymbol.asClass

//val classMirror: ru.ClassMirror = instanceMirror.reflectClass(sampleClass)


val clazz: Class[BottleBox] = classOf[BottleBox]

val fields = clazz.getFields // 해당 class의 field들을 인식할 수 없음.

fields.foreach(println)

println("checker")