package model.log

case class LogEntry(
  method: String,
  path: String,
  status: Int,
  query_string: Option[String],
  body: Option[String],
  host: String,
  port: Option[Int])