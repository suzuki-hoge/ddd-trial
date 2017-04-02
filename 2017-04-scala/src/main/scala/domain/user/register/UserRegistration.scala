package domain.user.register

import domain.credit_card.CreditCardInvalidReason
import domain.user._
import domain.user.register.error.UserRegistrationError
import domain.user.register.same_user_validation.AlreadyRegistered

object UserRegistration {
  def register(
                userName: UserName,
                address: Address,
                age: Age,
                eMail: EMail,
                registrationDate: RegistrationDate,
                alreadyRegistered: Either[AlreadyRegistered, Unit],
                creditCardInvalidReason: Either[CreditCardInvalidReason, Unit]
                ): Either[UserRegistrationError, AppliedUser] = {
    for {
      _ <- age.isAdult.left.map(_.toUserRegistrationError).right
      _ <- alreadyRegistered.left.map(_.toUserRegistrationError).right
      _ <- creditCardInvalidReason.left.map(_.toUserRegistrationError).right
    } yield AppliedUser(userName, address, age, eMail, registrationDate, Course.Free)
  }
}
