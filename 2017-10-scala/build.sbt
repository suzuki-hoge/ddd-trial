name := "ddd-trial2"

version := "1.0"

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.4" % "test"
)

doctestTestFramework := DoctestTestFramework.ScalaTest
