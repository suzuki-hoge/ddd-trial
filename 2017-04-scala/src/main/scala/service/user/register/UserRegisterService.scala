package service.user.register

import domain.credit_card.{CreditCardNumber, CreditCardRepository}
import domain.user._
import domain.user.register.error.UserRegistrationError
import domain.user.register.same_user_validation.{SameUserValidation, SameUserValidationRepository}
import domain.user.register.{Password, UserRegisterRepository, UserRegistration}

case class UserRegisterService(
                                sameUserValidationRepository: SameUserValidationRepository,
                                creditCardRepository: CreditCardRepository,
                                userRegisterRepository: UserRegisterRepository
                                ) {
  def register(
                userName: UserName,
                address: Address,
                age: Age,
                eMail: EMail,
                creditCardNumber: CreditCardNumber,
                registrationDate: RegistrationDate
                ): Either[UserRegistrationError, (UserId, Password)] = {
    UserRegistration.register(
      userName,
      address,
      age,
      eMail,
      registrationDate,
      sameUserValidationRepository.isValid(SameUserValidation(userName)),
      creditCardRepository.isValid(creditCardNumber)
    ).right.map {
      appliedUser => userRegisterRepository.register(appliedUser)
    }
  }
}
