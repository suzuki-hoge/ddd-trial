package data_source.credit_card

import domain.credit_card.{CreditCardInvalidReason, CreditCardNumber, CreditCardRepository}

case class CreditCardRepositoryImpl(fetcher: () => String) extends CreditCardRepository {
  override def isValid(creditCardNumber: CreditCardNumber): Either[CreditCardInvalidReason, Unit] = {
    CreditCardInvalidCode(fetcher()).toReason
  }
}
