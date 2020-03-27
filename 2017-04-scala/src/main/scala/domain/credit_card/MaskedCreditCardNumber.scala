package domain.credit_card

case class MaskedCreditCardNumber(value: String)

object MaskedCreditCardNumber {
  def create(value: String) = MaskedCreditCardNumber("****-****-****-" ++ value.drop(15))
}
