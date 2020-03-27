package domain.user.register.error

case class UserRegistrationError(reason: UserRegistrationInvalidReason, message: UserRegistrationInvalidMessage)
