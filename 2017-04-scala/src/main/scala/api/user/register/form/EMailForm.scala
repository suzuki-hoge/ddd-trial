package api.user.register.form

import api.validation.ValidationError
import domain.user.EMail

object EMailForm {
  def bind(value: String): Either[ValidationError, EMail] = value match {
    case "" => Left(ValidationError("not empty"))
    case x if x.count(_ == '@') != 1 => Left(ValidationError("@ must be 1"))
    case x => Right(EMail(x))
  }
}
