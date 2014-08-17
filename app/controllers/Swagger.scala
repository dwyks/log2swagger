package controllers

import model.log._
import model.swagger._

object Swagger {

  val swaggerVersion: String = "1.2"

  def writeResourceListing(logData: Seq[LogEntry]) = {
    val logSet = logData.toSet
    val resourceListing = {
      val resources = logSet.map { l =>
        Resource(
          path = l.path,
          description = "")
      }

      ResourceListing(
        apiVersion = "1.0",
        swaggerVersion = swaggerVersion,
        apis = resources.toSeq,
        authorizations = None,
        info = None)
    }
  }
}