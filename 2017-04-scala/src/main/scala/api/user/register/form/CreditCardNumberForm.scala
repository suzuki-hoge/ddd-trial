package api.user.register.form

import api.validation.ValidationError
import domain.credit_card.CreditCardNumber

object CreditCardNumberForm {
  def bind(value: String): Either[ValidationError, CreditCardNumber] = value match {
    case "" => Left(ValidationError("not empty"))
    case x if x.length() != 16 => Left(ValidationError("length must be 16"))
    case x => Right(CreditCardNumber(x))
  }
}
