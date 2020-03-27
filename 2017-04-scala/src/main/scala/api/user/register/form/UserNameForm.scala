package api.user.register.form

import api.validation.ValidationError
import domain.user.UserName

object UserNameForm {
  def bind(value: String): Either[ValidationError, UserName] = value match {
    case "" => Left(ValidationError("not empty"))
    case x => Right(UserName(x))
  }
}
