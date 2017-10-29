package domain.sign_up.application

import domain.core.birth_date.BirthDate
import org.scalatest.FunSuite

class BirthDateForSignUpApplicableCheckTest extends FunSuite {
  test("of") {
    val birth = BirthDate(1990)

    assert(
      BirthDateForSignUpApplicableCheck.of(birth, 2000) == Minors
    )
    assert(
      BirthDateForSignUpApplicableCheck.of(birth, 2010) == Majors
    )
  }
}
