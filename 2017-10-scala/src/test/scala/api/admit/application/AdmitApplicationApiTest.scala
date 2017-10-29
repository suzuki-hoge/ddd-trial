package api.admit.application

import domain.admit.error.InvalidCreditCard
import domain.authentication.UserPassword
import domain.core.user.UserId
import org.scalatest.FunSuite
import service.admit.AdmitApplicationService.Service

class AdmitApplicationApiTest extends FunSuite {
  test("validation error") {
    val service: Service = _ => Left(InvalidCreditCard)

    assert(
      AdmitApplicationApi.apply("", "", "", "", "", service) == Left("ValidationError [UserNameForm]: not empty")
    )
  }

  test("business error") {
    val service: Service = _ => Left(InvalidCreditCard)

    assert(
      AdmitApplicationApi.apply("John", "Tokyo", "1900", "boss@msf", "1234", service) == Left("BusinessError invalid credit card")
    )
  }

  test("success") {
    val applied = Right((UserId("1"), UserPassword("1")))
    val service: Service = _ => applied

    assert(
      AdmitApplicationApi.apply("John", "Tokyo", "1900", "boss@msf", "1234", service) == applied
    )
  }
}
