package api.user.register.form

import api.validation.ValidationError
import domain.user.Age

object AgeForm {
  def bind(value: String): Either[ValidationError, Age] = value match {
    case "" => Left(ValidationError("not empty"))
    case x if x.contains("a") => Left(ValidationError("only num"))
    case x => Right(Age(Integer.valueOf(x)))
  }
}
