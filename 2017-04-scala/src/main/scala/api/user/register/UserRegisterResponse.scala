package api.user.register

import api.validation.ValidationError
import domain.user.UserId
import domain.user.register.Password
import domain.user.register.error.UserRegistrationError

case class UserRegisterResponse(params: Seq[(String, String)]) {
  def toJson = "halfhearted..."
}

object UserRegisterResponse {
  def create(result: Either[ValidationError, Either[UserRegistrationError, (UserId, Password)]]): UserRegisterResponse = {
    UserRegisterResponse(result match {
      case Left(ve) => List(("error_reason", "validation-error"), ("error_message", ve.message))
      case Right(Left(ure)) => List(("error_reason", ure.reason.name()), ("error_message", ure.message.value))
      case Right(Right((id, pw))) => List(("user_id", id.value), ("password", pw.value))
    })
  }
}
