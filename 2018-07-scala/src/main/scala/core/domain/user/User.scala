package core.domain.user

case class UserId(v: String)

case class UserName(v: String)

case class UserBirthDate(v: String) {
  def isMinority: Boolean = if (v == "applicable") false else true
}

case class UserGender(v: String)
