package api.sign_up.application

import api.sign_up.application.SignUpApplicationApi.Service
import domain.authentication.UserPassword
import domain.core.user.UserId
import domain.sign_up.error.InvalidCreditCard
import org.scalatest.FunSuite

class SignUpApplicationApiTest extends FunSuite {
  test("validation error") {
    val service: Service = _ => Left(InvalidCreditCard)

    assert(
      SignUpApplicationApi.apply("", "", "", "", "", service) == Left("ValidationError [UserNameForm]: not empty")
    )
  }

  test("business error") {
    val service: Service = _ => Left(InvalidCreditCard)

    assert(
      SignUpApplicationApi.apply("John", "Tokyo", "1900", "boss@msf", "1234", service) == Left("BusinessError invalid credit card")
    )
  }

  test("success") {
    val applied = Right((UserId("1"), UserPassword("1")))
    val service: Service = _ => applied

    assert(
      SignUpApplicationApi.apply("John", "Tokyo", "1900", "boss@msf", "1234", service) == applied
    )
  }
}
