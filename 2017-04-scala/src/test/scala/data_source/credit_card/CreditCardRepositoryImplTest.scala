package data_source.credit_card

import domain.credit_card.{CreditCardInvalidReason, CreditCardNumber}
import org.scalatest.FunSuite

class CreditCardRepositoryImplTest extends FunSuite {
  val creditCardNumber = CreditCardNumber("1111-2222-3333-4444")

  test("valid") {
    val fetcher = () => "00"

    val exp = CreditCardRepositoryImpl(fetcher).isValid(creditCardNumber)
    val act = Right()

    assert(exp == act)
  }

  test("expected invalid") {
    val fetcher = () => "10"

    val exp = CreditCardRepositoryImpl(fetcher).isValid(creditCardNumber)
    val act = Left(CreditCardInvalidReason.InvalidNumber)

    assert(exp == act)
  }

  test("unexpected invalid") {
    intercept[MatchError] {
      val fetcher = () => "xx"

      CreditCardRepositoryImpl(fetcher).isValid(creditCardNumber)
    }
  }
}
