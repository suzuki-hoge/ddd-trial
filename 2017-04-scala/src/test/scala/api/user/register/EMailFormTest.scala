package api.user.register

import api.user.register.form.EMailForm
import api.validation.ValidationError
import domain.user.EMail
import org.scalatest.FunSuite

class EMailFormTest extends FunSuite {
  test("valid") {
    assert(EMailForm.bind("foo@bar") == Right(EMail("foo@bar")))
  }

  test("invalid 1") {
    assert(EMailForm.bind("") == Left(ValidationError("not empty")))
  }

  test("invalid 2") {
    assert(EMailForm.bind("foo@bar@baz") == Left(ValidationError("@ must be 1")))
  }
}
