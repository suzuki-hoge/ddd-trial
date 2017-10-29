package api.sign_up.application.form

import api.core.form.address.AddressForm
import api.core.form.birth_date.BirthDateForm
import api.core.form.credit_card.CreditCardForm
import api.core.form.mail_address.MailAddressForm
import api.core.form.user_name.UserNameForm
import domain.sign_up.application.SignUpApplication

object SignUpApplicationForm {
  def bind(name: String, address: String, birth: String, mail: String, card: String): Either[String, SignUpApplication] = for {
    n <- UserNameForm.bind(name).right
    a <- AddressForm.bind(address).right
    b <- BirthDateForm.bind(birth).right
    m <- MailAddressForm.bind(mail).right
    c <- CreditCardForm.bind(card).right
  } yield SignUpApplication(n, a, b, m, c)
}
