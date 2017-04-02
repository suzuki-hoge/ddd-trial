package api.user.register.form

import api.validation.ValidationError
import domain.user.Address

object AddressForm {
  def bind(value: String): Either[ValidationError, Address] = value match {
    case "" => Left(ValidationError("not empty"))
    case x => Right(Address(x))
  }
}
