package entry_application.domain

import core.domain.credit_card.CreditCardNumber
import core.domain.user.UserId

import scala.util.Try

trait EntryApplicationCreditCardRepository {
  def isValid(creditCardNumber: CreditCardNumber): Try[Boolean]

  def entry(id: UserId, app: EntryCreditCardApplication): Try[Unit]
}
