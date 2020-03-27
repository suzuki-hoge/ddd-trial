package core.form

import core.domain.credit_card.CreditCardNumber
import scalaz.Scalaz._
import scalaz.ValidationNel

object CreditCardNumberForm {
  def apply(s: String): ValidationNel[String, CreditCardNumber] = s match {
    case "applicable" => CreditCardNumber(s).successNel
    case _ => "Invalid value on CreditCardNumberForm".failureNel
  }
}
