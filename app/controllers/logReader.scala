package controllers

import scala.io.Source
import scala.util.parsing.json.JSON
import play.api.libs.json._
import play.api.libs.functional.syntax._

case class LogEntry(
  method: String,
  path: String,
  status: Int,
  query_string: Option[String],
  body: Option[String],
  host: String,
  port: Option[Int])
//    headers: Option[Seq[Map[String, String]]])

//  case class Header(
//    contentType: String)
//
//  implicit val headerReads: Reads[Header] = (
//      (__ \ "Content-Type").read[String]
//  )

object jsons {

  implicit val logEntryReads: Reads[LogEntry] = (
    (__ \ "method").read[String] and
    (__ \ "path").read[String] and
    (__ \ "status").read[Int] and
    (__ \ "query_string").readNullable[String] and
    (__ \ "body").readNullable[String] and
    (__ \ "host").read[String] and
    (__ \ "port").readNullable[Int])(LogEntry.apply _)
  //    (__ \ "headers").readNullable[Seq[Map[String, String]]])(LogEntry.apply _)
}

object logReader {

  import jsons._
  val readLogEntry = (__).read[List[LogEntry]]
  def main(args: Array[String]) {
    val log = readLog
    //    println(log.length)
  }

  def readLog = {
    val filename = "sample_api_traffic.log2"
    val content = Source.fromFile(filename).mkString
    val json = Json.parse(content)
    val logData = json.validate(readLogEntry) match {
      case s: JsSuccess[List[LogEntry]] => s.get
      case e: JsError => println("Errors: " + JsError.toFlatJson(e).toString)
    }
    println(logData)
  }
}