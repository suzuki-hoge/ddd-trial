package domain.user.register.same_user_validation

import domain.user.UserName
import domain.user.register.error.{UserRegistrationError, UserRegistrationInvalidMessage, UserRegistrationInvalidReason}

case class AlreadyRegistered(userName: UserName) {
  def toUserRegistrationError: UserRegistrationError = UserRegistrationError(
    UserRegistrationInvalidReason.AlreadyRegistered, UserRegistrationInvalidMessage(userName.value ++ " is already registered.")
  )
}
