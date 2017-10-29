package domain.admit.application

import domain.core.credit_card.{CreditCardVerificationResult, Invalid}
import domain.admit.application.same_user.{Exist, SameUserForAdmitApplicableCheck}
import domain.admit.error.{AlreadyAdmitted, InvalidCreditCard, MinorsCannotApply, RejectReason}

object AdmitApplicablePolicy {
  def check(
             birth: BirthDateForAdmitApplicableCheck,
             card: () => CreditCardVerificationResult,
             user: () => SameUserForAdmitApplicableCheck
             ): Either[RejectReason, Unit] = {
    if (birth == Minors) Left(MinorsCannotApply)
    else if (card() == Invalid) Left(InvalidCreditCard)
    else if (user() == Exist) Left(AlreadyAdmitted)
    else Right()
  }
}
