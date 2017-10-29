package api.sign_up.application.form

import domain.core.address.Address
import domain.core.birth_date.BirthDate
import domain.core.credit_card.CreditCard
import domain.core.mail_address.MailAddress
import domain.core.user_name.UserName
import domain.sign_up.application.SignUpApplication
import org.scalatest.FunSuite

class SignUpApplicationFormTest extends FunSuite {
  test("bind") {
    // failure
    assert(
      SignUpApplicationForm.bind(
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
      SignUpApplicationForm.bind(
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
      SignUpApplicationForm.bind(
        "John",
        "Tokyo",
        "1900",
        "boss@msf",
        "1234"
      ) == Right(
        SignUpApplication(
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
