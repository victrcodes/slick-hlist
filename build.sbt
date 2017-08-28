name := """slick-hlist"""

version := "1.0"

scalaVersion := "2.12.3"

libraryDependencies ++= Seq(
	"org.scalatest" %% "scalatest" % "3.0.1" % "test",
	"com.typesafe.slick" %% "slick" % "3.2.1",
	"com.typesafe.slick" %% "slick-hikaricp" % "3.2.1",
	"com.typesafe.slick" %% "slick-codegen" % "3.2.1",
	"org.slf4j" % "slf4j-nop" % "1.6.4",
	"com.h2database" % "h2" % "1.4.196",
	"com.chuusai" %% "shapeless" % "2.3.2",
	"io.underscore" %% "slickless" % "0.3.2"
)

val db: TaskKey[Unit] = taskKey[Unit]("db")
db := {
	val outputDir = "src/main/scala"
	val url = "jdbc:h2:mem:test1;DB_CLOSE_DELAY=-1;INIT=runscript from 'src/main/resources/create.sql'"
	val jdbcDriver = "org.h2.Driver"
	val slickDriver = "slick.jdbc.H2Profile"
	val pkg = "db"
	(runner in Compile).value.run(
		"slick.codegen.SourceCodeGenerator",
		(dependencyClasspath in Compile).value.files,
		Array(slickDriver, jdbcDriver, url, outputDir, pkg),
		streams.value.log
	)
	val fname = outputDir + "Tables.scala"
	Seq(file(fname))
}

//scalacOptions += "-feature"

//lazy val startupTransition: State => State = { s: State =>
//	"db" :: s
//}
//
//lazy val root = (project in file("."))
//	.settings(
//		onLoad in Global := {
//			val old = (onLoad in Global).value
//			startupTransition compose old
//		}
//	)