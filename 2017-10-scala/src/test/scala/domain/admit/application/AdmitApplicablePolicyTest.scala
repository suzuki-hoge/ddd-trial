package domain.admit.application

import domain.core.credit_card.{Invalid, Valid}
import domain.admit.application.same_user.{Exist, NotExist}
import domain.admit.error.{AlreadyAdmitted, InvalidCreditCard, MinorsCannotApply}
import org.scalatest.FunSuite

class AdmitApplicablePolicyTest extends FunSuite {
  test("check") {
    val na = () => throw new RuntimeException("n/a")

    assert(
      AdmitApplicablePolicy.check(Minors, na, na) == Left(MinorsCannotApply)
    )
    assert(
      AdmitApplicablePolicy.check(Majors, () => Invalid, na) == Left(InvalidCreditCard)
    )
    assert(
      AdmitApplicablePolicy.check(Majors, () => Valid, () => Exist) == Left(AlreadyAdmitted)
    )
    assert(
      AdmitApplicablePolicy.check(Majors, () => Valid, () => NotExist) == Right()
    )
  }
}
