package domain.admit.application

import domain.core.birth_date.BirthDate

sealed trait BirthDateForAdmitApplicableCheck

case object Majors extends BirthDateForAdmitApplicableCheck

case object Minors extends BirthDateForAdmitApplicableCheck

object BirthDateForAdmitApplicableCheck {
  def of(birth: BirthDate, now: Int): BirthDateForAdmitApplicableCheck = birth.isMinors(now) match {
    case true => Minors
    case false => Majors
  }
}
