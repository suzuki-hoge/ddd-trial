package api.core.form.user_name

import domain.core.user_name.UserName

object UserNameForm {
  def bind(value: String): Either[String, UserName] = value match {
    case "" => Left("[UserNameForm]: not empty")
    case x => Right(UserName(x))
  }
}
