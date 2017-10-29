package api.core.user.form

import domain.core.user.UserId

object UserIdForm {
  def bind(value: String): Either[String, UserId] = value match {
    case "" => Left("[UserIdForm]: not empty")
    case x => Right(UserId(x))
  }
}
