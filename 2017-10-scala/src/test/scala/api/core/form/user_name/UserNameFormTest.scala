package api.core.form.user_name

import domain.core.user_name.UserName
import org.scalatest.FunSuite

class UserNameFormTest extends FunSuite {
  test("bind") {
    // failure
    assert(
      UserNameForm.bind("") == Left("[UserNameForm]: not empty")
    )

    // success
    assert(
      UserNameForm.bind("John") == Right(UserName("John"))
    )
  }
}
