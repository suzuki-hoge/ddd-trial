package domain.credit_card

trait CreditCardRepository {
  def isValid(creditCardNumber: CreditCardNumber): Either[CreditCardInvalidReason, Unit]
}
