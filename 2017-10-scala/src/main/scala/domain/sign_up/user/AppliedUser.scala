package domain.sign_up.user

import domain.core.address.Address
import domain.core.birth_date.BirthDate
import domain.core.mail_address.MailAddress
import domain.core.user.{Course, UserId}
import domain.core.user_name.UserName
import domain.sign_up.application.SignUpApplicationDateTime

case class AppliedUser(id: UserId, name: UserName, address: Address, birth: BirthDate, mail: MailAddress, course: Course, at: SignUpApplicationDateTime)
