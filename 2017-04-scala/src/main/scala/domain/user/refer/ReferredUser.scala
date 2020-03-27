package domain.user.refer

import domain.credit_card.MaskedCreditCardNumber
import domain.user._

case class ReferredUser(
                         userId: UserId,
                         userName: UserName,
                         address: Address,
                         age: Age,
                         maskedCreditCardNumber: MaskedCreditCardNumber,
                         eMail: EMail,
                         registrationDate: RegistrationDate
                         )
