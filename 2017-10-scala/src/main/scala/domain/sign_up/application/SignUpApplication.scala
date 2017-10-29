package domain.sign_up.application

import domain.core.address.Address
import domain.core.birth_date.BirthDate
import domain.core.credit_card.CreditCard
import domain.core.mail_address.MailAddress
import domain.core.user.{Free, UserId}
import domain.core.user_name.UserName
import domain.sign_up.application.same_user.SameUser
import domain.sign_up.user.AppliedUser

case class SignUpApplication(name: UserName, address: Address, birth: BirthDate, mail: MailAddress, card: CreditCard) {
  def sameUser(): SameUser = {
    SameUser(name)
  }

  def birthDate(now: Int): BirthDateForSignUpApplicableCheck = {
    BirthDateForSignUpApplicableCheck.of(birth, now)
  }

  def signUp(id: UserId, at: SignUpApplicationDateTime): AppliedUser = {
    AppliedUser(id, name, address, birth, mail, Free, at)
  }
}
