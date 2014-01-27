name := "decode"

version :="0.1"

libraryDependencies ++= Seq("org.specs2" %% "specs2" % "2.3.7" % "test")

scalacOptions in Test ++= Seq("-Yrangepos")
 
resolvers ++= Seq("snapshots", "releases").map(Resolver.sonatypeRepo)

