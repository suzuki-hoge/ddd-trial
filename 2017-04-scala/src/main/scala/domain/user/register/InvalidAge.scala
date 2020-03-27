package domain.user.register

import domain.user.register.error.{UserRegistrationError, UserRegistrationInvalidMessage, UserRegistrationInvalidReason}

case class InvalidAge(value: Int) {
  def toUserRegistrationError: UserRegistrationError = UserRegistrationError(
    UserRegistrationInvalidReason.NonAdult, UserRegistrationInvalidMessage(value.toString ++ " is too young.")
  )
}
