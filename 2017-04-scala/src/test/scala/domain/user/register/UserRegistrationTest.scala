package domain.user.register

import domain.credit_card.CreditCardInvalidReason
import domain.user._
import domain.user.register.error.{UserRegistrationError, UserRegistrationInvalidMessage, UserRegistrationInvalidReason}
import domain.user.register.same_user_validation.AlreadyRegistered
import org.scalatest.FunSuite

class UserRegistrationTest extends FunSuite {
  val userName = UserName("john")
  val address = Address("tokyo")
  val age = Age(20)
  val eMail = EMail("john@foo")
  val registrationDate = RegistrationDate("0402")

  test("valid") {
    val exp = UserRegistration.register(
      userName, address, age, eMail, registrationDate, Right(), Right()
    )
    val act = Right(
      AppliedUser(userName, address, age, eMail, registrationDate, Course.Free)
    )

    assert(exp == act)
  }

  test("invalid caused by non adult") {
    val exp = UserRegistration.register(
      userName, address, Age(19), eMail, registrationDate, Right(), Right()
    )
    val act = Left(
      UserRegistrationError(
        UserRegistrationInvalidReason.NonAdult,
        UserRegistrationInvalidMessage("19 is too young.")
      )
    )

    assert(exp == act)
  }

  test("invalid caused by already registered") {
    val exp = UserRegistration.register(
      userName, address, age, eMail, registrationDate, Left(AlreadyRegistered(userName)), Right()
    )
    val act = Left(
      UserRegistrationError(
        UserRegistrationInvalidReason.AlreadyRegistered,
        UserRegistrationInvalidMessage("john is already registered.")
      )
    )

    assert(exp == act)
  }

  test("invalid caused by invalid credit card") {
    val exp = UserRegistration.register(
      userName, address, age, eMail, registrationDate, Right(), Left(CreditCardInvalidReason.InvalidNumber)
    )
    val act = Left(
      UserRegistrationError(
        UserRegistrationInvalidReason.InvalidCreditCard,
        UserRegistrationInvalidMessage("invalid card number.")
      )
    )

    assert(exp == act)
  }
}
