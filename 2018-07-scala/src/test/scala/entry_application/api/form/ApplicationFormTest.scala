package entry_application.api.form

import core.domain.credit_card.CreditCardNumber
import core.domain.user.{UserBirthDate, UserName}
import entry_application.api.EntryCheckApplicationForm
import entry_application.domain.EntryCheckApplication
import org.scalatest.FunSuite
import scalaz.Success

class ApplicationFormTest extends FunSuite {
  test("check") {
    assert(
      EntryCheckApplicationForm(
        "applicable", "applicable", "applicable"
      ) == Success(EntryCheckApplication(
        UserName("applicable"), UserBirthDate("applicable"), CreditCardNumber("applicable"))
      )
    )
  }
}
