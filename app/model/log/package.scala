package model

import play.api.libs.json._
import play.api.libs.functional.syntax._

package object log {

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