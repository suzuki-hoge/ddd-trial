package domain.credit_card

import org.scalatest.FunSuite

class MaskedCreditCardNumberTest extends FunSuite {
  test("mask") {
    assert(MaskedCreditCardNumber.create("1111-2222-3333-4444").value == "****-****-****-4444")
  }
}
