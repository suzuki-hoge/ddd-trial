package api.user.refer.form

import api.validation.ValidationError
import domain.user.UserId

object UserIdForm {
  def bind(value: String): Either[ValidationError, UserId] = value match {
    case "" => Left(ValidationError("not empty"))
    case x => Right(UserId(x))
  }
}
