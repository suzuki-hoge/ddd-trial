package entry_application.data_source

import core.domain.credit_card.CreditCardNumber
import core.domain.user.UserId
import entry_application.domain.{EntryApplicationCreditCardRepository, EntryCreditCardApplication}

import scala.util.{Success, Try}

object EntryApplicationCreditCardRepositoryImpl extends EntryApplicationCreditCardRepository {
  override def isValid(number: CreditCardNumber): Try[Boolean] = number.v match {
    case "applicable" => Success(callSomething)
  }

  private def callSomething: Boolean = {
    "code-001"
  }

  override def entry(id: UserId, app: EntryCreditCardApplication): Try[Unit] = {
    Success()
  }

  implicit private def fromSystemValue(s: String): Boolean = if (s == "code-001") true else false
}
