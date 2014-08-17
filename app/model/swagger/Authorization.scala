package model.swagger

case class Authorization(
  authType: String,
  passAs: String,
  keyname: String,
  scopes: Seq[Scope],
  grantTypes: GrantTypes)