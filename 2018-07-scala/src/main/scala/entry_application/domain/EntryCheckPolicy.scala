package entry_application.domain

import core.domain.user.UserBirthDate

object EntryCheckPolicy {
  def check(
             sameUserExists: Boolean,
             userBirthDate: UserBirthDate,
             isValidCreditCard: Boolean
           ): Either[EntryCheckError, Unit] = (sameUserExists, userBirthDate.isMinority, isValidCreditCard) match {
    case (false, false, true) => Right()
    case (true, _, _) => Left(SameUserExists)
    case (_, true, _) => Left(Minority)
    case (_, _, false) => Left(InvalidCreditCard)
  }
}
