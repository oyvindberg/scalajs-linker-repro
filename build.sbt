name := "repro"
enablePlugins(ScalaJSPlugin)
scalaJSUseMainModuleInitializer := true
libraryDependencies ++= Seq(
  "org.parboiled" %%% "parboiled" % "2.1.4",
  "com.chuusai" %%% "shapeless" % "2.3.2",
)