package model.swagger

case class ResourceListing(
  apiVersion: String,
  swaggerVersion: String,
  apis: Seq[Resource],
  authorizations: Option[Seq[Authorization]],
  info: Option[Info])