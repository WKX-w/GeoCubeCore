package whu.edu.cn.util

import java.sql.{Connection, DriverManager, PreparedStatement}
import java.util.{Objects, Properties}

/**
 * A config class for postresql connection.
 * */
class PostgresqlUtil (sql: String){
  PostgresqlUtil.get()
  Class.forName(PostgresqlUtil.driver)
  private val connection: Connection = DriverManager.getConnection(PostgresqlUtil.url, PostgresqlUtil.user, PostgresqlUtil.password);
//  private val connection: Connection = DriverManager.getConnection(url, user, password);
  private val statement: PreparedStatement = connection.prepareStatement(sql)

  def getConnection():Connection = connection

  def getStatement(): PreparedStatement = statement

  def close(): Unit = {
    try {
      this.connection.close()
      this.statement.close()
    } catch {
      case e: Exception =>
        e.printStackTrace()
    }
  }
}
object PostgresqlUtil{
  //val url = "jdbc:postgresql://125.220.153.26:5432/geocube"
  //val url = "jdbc:postgresql://125.220.153.26:5432/whugeocube"
//  val url = "jdbc:postgresql://125.220.153.26:5432/multigeocube"
//  val url = "jdbc:postgresql://172.20.20.9:25432/multigeocube"
//  val driver = "org.postgresql.Driver"
//  val user = "geocube"
////  val password = "ypfamily608"
//  val password = "ypfamilysouthgis"
  var url = ""
  var driver = ""
  var user = ""
  //  val password = "ypfamily608"
  var password = ""
  def get(): Unit ={
    val prop = new Properties()
    val inputStream = PostgresqlUtil.getClass.getClassLoader.getResourceAsStream("app.properties")
    prop.load(inputStream);

    this.url=prop.get("url").toString
    this.driver=prop.get("driver").toString
    this.user=prop.get("user").toString
    this.password=prop.get("password").toString
  }
}
