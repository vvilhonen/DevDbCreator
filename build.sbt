name := "DevDbCreator"

scalaVersion := "2.10.1"

libraryDependencies ++= Seq(
  "net.databinder" %% "unfiltered-filter" % "0.6.8",
  "com.typesafe.slick" %% "slick" % "1.0.0",
  "ch.qos.logback" % "logback-classic" % "1.0.12",
  "mysql" % "mysql-connector-java" % "5.1.23",
  "com.typesafe" % "config" % "1.0.0")

