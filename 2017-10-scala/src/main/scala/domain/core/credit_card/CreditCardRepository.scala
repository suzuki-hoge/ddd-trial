package domain.core.credit_card

trait CreditCardRepository {
  def verify(creditCard: CreditCard): CreditCardVerificationResult
}
