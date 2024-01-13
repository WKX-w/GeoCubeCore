package whu.edu.cn.util

import java.io.{BufferedReader, InputStreamReader, PrintWriter}
import java.net.{URL, URLConnection}
import java.nio.charset.StandardCharsets

object HttpRequestUtil {
//  /**
//   * 向指定URL发送GET方式的请求
//   *
//   * @param url 发送请求的URL
//   * @return URL 代表远程资源的响应
//   */
//  def sendGet(url: String): String = {
//    val result = new StringBuilder()
//    try {
//      val realUrl = new URL(url)
//      // 打开和URL之间的连接
//      val conn = realUrl.openConnection()
//      // 设置通用的请求属性
//      conn.setRequestProperty("accept", "*/*")
//      conn.setRequestProperty("connection", "Keep-Alive")
//      conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)")
//      // 建立实际的连接
//      conn.connect()
//      // 获取所有的响应头字段
//      val map = conn.getHeaderFields()
//      // 遍历所有的响应头字段
//      for (key <- map.keySet()) {
//        println(s"$key --> ${map.get(key)}")
//      }
//      // 定义 BufferedReader输入流来读取URL的响应
//      val in = new BufferedReader(new InputStreamReader(conn.getInputStream))
//      var line: String = null
//      while ({line = in.readLine(); line != null}) {
//        result.append(line)
//      }
//    } catch {
//      case e: Exception =>
//        println(s"发送GET请求出现异常: $e")
//        e.printStackTrace()
//    }
//    result.toString()
//  }

  /**
   * 向指定URL发送POST方式的请求
   *
   * @param url   发送请求的URL
   * @param param 请求参数
   * @return URL 代表远程资源的响应
   */
  def sendPost(url: String, param: String): String = {
    val result = new StringBuilder()
    try {
      val realUrl = new URL(url)
      // 打开和URL之间的连接
      val conn = realUrl.openConnection()
      // 设置通用的请求属性
      conn.setRequestProperty("accept", "*/*")
      conn.setRequestProperty("connection", "Keep-Alive")
      conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)")
      conn.setRequestProperty("Content-Type", "application/json; charset=utf-8")
      // 发送POST请求必须设置如下两行
      conn.setDoOutput(true)
      conn.setDoInput(true)
      // 获取URLConnection对象对应的输出流
      val out = new PrintWriter(conn.getOutputStream)
      // 发送请求参数
      out.print(param)
      // flush输出流的缓冲
      out.flush()
      // 定义 BufferedReader输入流来读取URL的响应
      val in = new BufferedReader(new InputStreamReader(conn.getInputStream, StandardCharsets.UTF_8))
      var line: String = null
      while ({line = in.readLine(); line != null}) {
        result.append("\n").append(line)
      }
    } catch {
      case e: Exception =>
        println(s"发送POST请求出现异常: $e")
        e.printStackTrace()
    }
    result.toString()
  }

}

