package data_source.credit_card

import domain.credit_card.CreditCardInvalidReason

case class CreditCardInvalidCode(value: String) {
  def toReason: Either[CreditCardInvalidReason, Unit] = value match {
    case "00" => Right()
    case "10" => Left(CreditCardInvalidReason.InvalidNumber)
    case "20" => Left(CreditCardInvalidReason.InvalidBirthDate)
  }
}
