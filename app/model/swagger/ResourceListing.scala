package model.swagger

case class ResourceListing(
  apiVersion: String,
  swaggerVersion: String,
  apis: Seq[Resource],
  authorizations: Seq[Authorization],
  info: Info)