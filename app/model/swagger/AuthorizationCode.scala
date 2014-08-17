package model.swagger

case class AuthorizationCode(
  tokenRequestEndpoint: TokenRequestEndpoint,
  tokenEndpoint: TokenEndpoint)