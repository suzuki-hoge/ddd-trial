package api.user.register

import api.user.register.form._
import domain.user.RegistrationDate
import service.user.register.UserRegisterService

case class UserRegisterApi(service: UserRegisterService) {
  val now = "0402"

  def register(
                userNameString: String,
                addressString: String,
                ageString: String,
                eMailString: String,
                creditCardNumberString: String
                ): UserRegisterResponse = UserRegisterResponse.create(
    for {
      userName <- UserNameForm.bind(userNameString).right
      address <- AddressForm.bind(addressString).right
      age <- AgeForm.bind(ageString).right
      eMail <- EMailForm.bind(eMailString).right
      creditCardNumber <- CreditCardNumberForm.bind(creditCardNumberString).right
    } yield service.register(
      userName, address, age, eMail, creditCardNumber, RegistrationDate(now)
    )
  )
}
