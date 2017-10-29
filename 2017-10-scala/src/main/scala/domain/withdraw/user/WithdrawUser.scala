package domain.withdraw.user

import domain.admit.application.AdmitApplicationDateTime
import domain.core.address.Address
import domain.core.birth_date.BirthDate
import domain.core.mail_address.MailAddress
import domain.core.user.UserId
import domain.core.user_name.UserName
import domain.withdraw.application.WithdrawApplicationDateTime

case class WithdrawUser(id: UserId, name: UserName, address: Address, birth: BirthDate, mail: MailAddress, at: AdmitApplicationDateTime) {
  def apply(now: String): WithdrawnUser = {
    WithdrawnUser(id, WithdrawApplicationDateTime(now))
  }
}
