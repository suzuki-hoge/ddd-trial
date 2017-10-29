package domain.admit.application

import domain.core.address.Address
import domain.core.birth_date.BirthDate
import domain.core.credit_card.CreditCard
import domain.core.mail_address.MailAddress
import domain.core.user.{Free, UserId}
import domain.core.user_name.UserName
import domain.admit.application.same_user.SameUser
import domain.admit.user.AdmittedUser

case class AdmitApplication(name: UserName, address: Address, birth: BirthDate, mail: MailAddress, card: CreditCard) {
  def sameUser(): SameUser = {
    SameUser(name)
  }

  def birthDate(now: Int): BirthDateForAdmitApplicableCheck = {
    BirthDateForAdmitApplicableCheck.of(birth, now)
  }

  def apply(id: UserId, at: AdmitApplicationDateTime): AdmittedUser = {
    AdmittedUser(id, name, address, birth, mail, Free, at)
  }
}
