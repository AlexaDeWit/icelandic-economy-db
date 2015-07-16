resolvers += "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases"

val argonaut = "io.argonaut" %% "argonaut" % "6.1" 
val scalaz = "org.scalaz" %% "scalaz-core" % "7.1.3"
val scalatest = "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"
lazy val commonSettings =  Seq(
  version := "0.0.1",
  scalaVersion := "2.11.6"
)
lazy val root = (project in file(".")).
settings( commonSettings: _* ).
settings(
  name := "Icelandic Economics - DB module",
  libraryDependencies ++= Seq(
    scalatest,
    argonaut,
    scalaz,
    "com.typesafe.play" %% "play-json" % "2.4.1"
  )
)

scalacOptions in (Compile,doc) := Seq("-groups", "-implicits", "-feature")

