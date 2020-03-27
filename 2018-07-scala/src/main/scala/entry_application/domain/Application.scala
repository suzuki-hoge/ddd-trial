package entry_application.domain

import core.domain.credit_card.CreditCardNumber
import core.domain.user.{UserBirthDate, UserGender, UserName}

case class EntryApplication(name: UserName, birthDate: UserBirthDate, gender: UserGender, number: CreditCardNumber) {
  def forUser: EntryUserApplication = EntryUserApplication(name, birthDate, gender)

  def forCreditCard: EntryCreditCardApplication = EntryCreditCardApplication(number)

  def forCheck: EntryCheckApplication = EntryCheckApplication(name, birthDate, number)
}

case class EntryUserApplication(name: UserName, birthDate: UserBirthDate, gender: UserGender)

case class EntryCreditCardApplication(creditCard: CreditCardNumber)

case class EntryCheckApplication(name: UserName, birthDate: UserBirthDate, number: CreditCardNumber)
