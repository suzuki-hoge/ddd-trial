package api.admit.application.form

import domain.core.address.Address
import domain.core.birth_date.BirthDate
import domain.core.credit_card.CreditCard
import domain.core.mail_address.MailAddress
import domain.core.user_name.UserName
import domain.admit.application.AdmitApplication
import org.scalatest.FunSuite

class AdmitApplicationFormTest extends FunSuite {
  test("bind") {
    // failure
    assert(
      AdmitApplicationForm.bind(
        "",
        "",
        "",
        "",
        ""
      ) == Left(
        "[UserNameForm]: not empty"
      )
    )

    // failure
    assert(
      AdmitApplicationForm.bind(
        "John",
        "",
        "",
        "",
        ""
      ) == Left(
        "[AddressForm]: not empty"
      )
    )

    // success
    assert(
      AdmitApplicationForm.bind(
        "John",
        "Tokyo",
        "1900",
        "boss@msf",
        "1234"
      ) == Right(
        AdmitApplication(
          UserName("John"),
          Address("Tokyo"),
          BirthDate(1900),
          MailAddress("boss@msf"),
          CreditCard("1234")
        )
      )
    )
  }
}
