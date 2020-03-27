package api.authentication.form

import api.validation.ValidationError
import domain.user.register.Password

object PasswordForm {
  def bind(value: String): Either[ValidationError, Password] = value match {
    case "" => Left(ValidationError("not empty"))
    case x => Right(Password(x))
  }
}
