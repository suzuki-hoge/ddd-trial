package domain.user.register

import domain.user.Age
import org.scalatest.FunSuite

class AgeTest extends FunSuite {
  test("valid") {
    assert(Age(20).isAdult == Right())
  }

  test("invalid") {
    assert(Age(19).isAdult == Left(InvalidAge(19)))
  }
}
