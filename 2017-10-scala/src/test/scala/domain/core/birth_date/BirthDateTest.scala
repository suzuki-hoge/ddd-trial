package domain.core.birth_date

import org.scalatest.FunSuite

class BirthDateTest extends FunSuite {
  test("minors") {
    assert(
      !BirthDate(1997).isMinors(2017)
    )
    assert(
      BirthDate(1998).isMinors(2017)
    )
  }
}
