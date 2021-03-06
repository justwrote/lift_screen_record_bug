import sbt._

class LiftProject(info: ProjectInfo) extends DefaultWebProject(info) with IdeaProject {
  val liftVersion = "2.3-SNAPSHOT"

  // uncomment the following if you want to use the snapshot repo
  val scalatoolsSnapshot = ScalaToolsSnapshots

  // If you're using JRebel for Lift development, uncomment
  // this line
  // override def scanDirectories = Nil

  override def libraryDependencies = Set(
    "net.liftweb" %% "lift-webkit" % liftVersion withSources,
    "net.liftweb" %% "lift-wizard" % liftVersion withSources,
    "net.liftweb" %% "lift-proto" % liftVersion withSources,
    "net.liftweb" %% "lift-util" % liftVersion withSources,
    "net.liftweb" %% "lift-mapper" % liftVersion withSources,
    "net.liftweb" %% "lift-mongodb" % liftVersion withSources,
    "net.liftweb" %% "lift-mongodb-record" % liftVersion withSources,
    "org.mongodb" % "mongo-java-driver" % "2.4",
    "org.mortbay.jetty" % "jetty" % "6.1.22" % "test->default",
    "junit" % "junit" % "4.5" % "test->default",
    "ch.qos.logback" % "logback-classic" % "0.9.26",
    "org.scala-tools.testing" %% "specs" % "1.6.6" % "test->default"
  ) ++ super.libraryDependencies
}
