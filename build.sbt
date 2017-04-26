
name := "scala-reflection"

version := "1.0"

scalaVersion in ThisBuild := "2.11.8"

mainClass in (Compile,run) := Some("main.AppTestMain")

lazy val reflection = project.in(file("."))
  .settings(
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-reflect" % scalaVersion.value
    )
  )





        