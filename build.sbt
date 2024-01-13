name := "geocube-core"

version := "0.1"

scalaVersion := "2.11.12"

organization := "whu.edu.cn"

libraryDependencies ++= Seq(
  "org.locationtech.geotrellis" % "geotrellis-raster_2.11" % "3.0.0",
  "org.locationtech.geotrellis" % "geotrellis-spark_2.11" % "3.0.0"
)

libraryDependencies ++= Seq(
  "org.apache.spark" % "spark-core_2.11" % "2.4.3",
  "org.apache.spark" % "spark-sql_2.11" % "2.4.3"
)

libraryDependencies ++= Seq(
  "org.apache.hbase" % "hbase-client" % "1.4.13",
  "org.apache.hbase" % "hbase-common" % "1.4.13",
  "org.apache.hbase" % "hbase-server" % "1.4.13"
)

libraryDependencies ++= Seq(
  "org.geotools" % "gt-main" % "21.2",
  "org.geotools" % "gt-shapefile" % "21.2" ,
  "org.geotools" % "gt-referencing" % "21.2",
  "org.geotools" % "gt-epsg-hsql" % "21.2",
  "org.geotools" % "gt-geojson" % "21.2"
)

libraryDependencies += "org.postgresql" % "postgresql" % "42.2.6"
libraryDependencies += "org.geonames" % "geonames" % "1.0"
libraryDependencies += "com.alibaba" % "fastjson" % "1.2.36"
libraryDependencies += "org.json4s" %% "json4s-native" % "3.6.12"
//libraryDependencies += "org.json4s" %% "json4s-ext" % "3.6.12" // 如果需要支持更多特性

//libraryDependencies += "com.lihaoyi" %% "upickle" % "1.4.1"



//libraryDependencies += "edu.ucar" % "netcdf" % "4.2.20"
//libraryDependencies += "edu.ucar" % "netcdf" % "5.5.3"
//published in local repository, or add ${project.basedir}/lib/ as dependency
//libraryDependencies ++= Seq(
//  "org.gdal" % "gdal" % "3.0.4",
//  "cern.colt" % "colt" % "1.2.0"
//)
//resolvers += "local-ivy" at "file:///E:/DataCube/scala/sbt/.ivy2/cache/"
resolvers += "local-ivy" at "file:///C:/Users/dell/.ivy2/cache"
//resolvers += "local-ivy" at "file:///F:/Library/scala/sbt/.ivy2/cache/"
resolvers += "OSGeo Release Repository" at "https://repo.osgeo.org/repository/release/"
resolvers += "OSGeo Snapshot Repository" at "https://repo.osgeo.org/repository/snapshot/"

//publish geocube-core as maven style, used in jupyter notebook
description := "geocube library"
publishMavenStyle := true
//publishTo := Some(Resolver.file("local-ivy", file("E:/DataCube/scala/sbt/.ivy2/cache")))
publishTo := Some(Resolver.file("local-ivy", file("C:/Users/dell/.ivy2/cache")))
//publishTo := Some(Resolver.file("local-ivy", file("F:/Library/scala/sbt/.ivy2/cache")))
publishConfiguration := publishConfiguration.value.withOverwrite(true)