package api.core.form.credit_card

import domain.core.credit_card.CreditCard

object CreditCardForm {
  def bind(number: String): Either[String, CreditCard] = number match {
    case "" => Left("[CreditCardForm]: not empty")
    case x => Right(CreditCard(x))
  }
}
