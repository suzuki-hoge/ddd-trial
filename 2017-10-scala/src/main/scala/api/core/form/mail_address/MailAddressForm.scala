package api.core.form.mail_address

import domain.core.mail_address.MailAddress

object MailAddressForm {
  def bind(value: String): Either[String, MailAddress] = value match {
    case "" => Left("[MailAddressForm]: not empty")
    case x => Right(MailAddress(x))
  }
}
