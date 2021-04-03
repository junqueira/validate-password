name := "password validate"

version := "1.0"
scalaVersion := "2.11.9"
sbtVersion := "1.3.8"

mainClass in(Compile, run) := Some("teste.PasswordValidate")
javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

resolvers in Global ++= Seq(
    "Sbt plugins" at "https://dl.bintray.com/sbt/sbt-plugin-releases",
    "Maven Central Server" at "https://repo1.maven.org/maven2",
    "TypeSafe Repository Releases" at "https://repo.typesafe.com/typesafe/releases/",
    "TypeSafe Repository Snapshots" at "https://repo.typesafe.com/typesafe/snapshots/"
)

resolvers += Resolver.bintrayIvyRepo("com.eed3si9n", "sbt-plugins")

libraryDependencies ++= Seq(
    "com.tumblr" % "colossus_2.11" % "0.9.0"
)

assemblyMergeStrategy in assembly := {
    case PathList("META-INF", xs@_*) => MergeStrategy.discard
    case x => MergeStrategy.first
}

libraryDependencies += "com.typesafe" % "config" % "1.3.1"
libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.8"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % "test"
