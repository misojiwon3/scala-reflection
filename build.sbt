
name := "scala-reflection"

version := "1.0"

scalaVersion in ThisBuild := "2.11.8"

mainClass in (Compile,run) := Some("main.Main")

lazy val reflection = project.in(file("."))
  .settings(
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-reflect" % scalaVersion.value
    )
  )





        