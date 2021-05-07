name := "scala-fs"

version := "0.1"

scalaVersion := "2.13.5"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.8" % "test"

libraryDependencies ++= Seq(
  "org.mockito" %% "mockito-scala" % "1.16.0" % "test"
)

scalacOptions ++= Seq("-encoding", "UTF-8")