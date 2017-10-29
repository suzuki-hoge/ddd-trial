package domain.sign_up.application

import domain.core.credit_card.{Invalid, Valid}
import domain.sign_up.application.same_user.{Exist, NotExist}
import domain.sign_up.error.{AlreadyApplied, InvalidCreditCard, MinorsCannotApply}
import org.scalatest.FunSuite

class SignUpApplicablePolicyTest extends FunSuite {
  test("check") {
    val na = () => throw new RuntimeException("n/a")

    assert(
      SignUpApplicablePolicy.check(Minors, na, na) == Left(MinorsCannotApply)
    )
    assert(
      SignUpApplicablePolicy.check(Majors, () => Invalid, na) == Left(InvalidCreditCard)
    )
    assert(
      SignUpApplicablePolicy.check(Majors, () => Valid, () => Exist) == Left(AlreadyApplied)
    )
    assert(
      SignUpApplicablePolicy.check(Majors, () => Valid, () => NotExist) == Right()
    )
  }
}
