ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.7.4"

lazy val root = (project in file("."))
  .settings(
    name := "why-machines-learn-scala",
    libraryDependencies ++= Seq(
      "io.github.iltotore" %% "iron" % "3.2.2",
      "org.scalatest" %% "scalatest" % "3.2.19" % Test
    )
  )
