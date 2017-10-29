package domain.admit.application

import domain.core.birth_date.BirthDate
import org.scalatest.FunSuite

class BirthDateForAdmitApplicableCheckTest extends FunSuite {
  test("of") {
    val birth = BirthDate(1990)

    assert(
      BirthDateForAdmitApplicableCheck.of(birth, 2000) == Minors
    )
    assert(
      BirthDateForAdmitApplicableCheck.of(birth, 2010) == Majors
    )
  }
}
