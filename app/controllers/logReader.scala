package controllers

import scala.io.Source
import play.api.libs.json._
import model.log._
import model.swagger._

object logReader {

  def main(args: Array[String]) {
    val log = readLog
    println(log)
  }

  val readLogEntry = (__).read[List[LogEntry]]

  def readLog = {
    val filename = "sample_api_traffic.log2"
    val content = Source.fromFile(filename).mkString
    val json = Json.parse(content)
    json.validate(readLogEntry) match {
      case s: JsSuccess[List[LogEntry]] => s.get
      case e: JsError => println("Errors: " + JsError.toFlatJson(e).toString)
    }
  }
}