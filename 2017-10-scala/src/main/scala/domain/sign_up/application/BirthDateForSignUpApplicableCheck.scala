package domain.sign_up.application

import domain.core.birth_date.BirthDate

sealed trait BirthDateForSignUpApplicableCheck

case object Majors extends BirthDateForSignUpApplicableCheck

case object Minors extends BirthDateForSignUpApplicableCheck

object BirthDateForSignUpApplicableCheck {
  def of(birth: BirthDate, now: Int): BirthDateForSignUpApplicableCheck = birth.isMinors(now) match {
    case true => Minors
    case false => Majors
  }
}
