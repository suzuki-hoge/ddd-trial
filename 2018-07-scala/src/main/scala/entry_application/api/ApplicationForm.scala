package entry_application.api

import core.form.{CreditCardNumberForm, UserBirthDateForm, UserGenderForm, UserNameForm}
import entry_application.domain.{EntryApplication, EntryCheckApplication}
import scalaz.Scalaz._
import scalaz.ValidationNel

object EntryCheckApplicationForm {
  def apply(name: String, birthDate: String, number: String): ValidationNel[String, EntryCheckApplication] = {
    (
      UserNameForm(name)
        |@| UserBirthDateForm(birthDate)
        |@| CreditCardNumberForm(number)
      ) (EntryCheckApplication)
  }
}

object EntryApplicationForm {
  def apply(name: String, birthDate: String, gender: String, number: String): ValidationNel[String, EntryApplication] = {
    (
      UserNameForm(name)
        |@| UserBirthDateForm(birthDate)
        |@| UserGenderForm(gender)
        |@| CreditCardNumberForm(number)
      ) (EntryApplication)
  }
}
