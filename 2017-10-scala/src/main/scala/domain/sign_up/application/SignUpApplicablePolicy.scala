package domain.sign_up.application

import domain.core.credit_card.{CreditCardVerificationResult, Invalid}
import domain.sign_up.application.same_user.{Exist, SameUserForSignUpApplicableCheck}
import domain.sign_up.error.{AlreadyApplied, InvalidCreditCard, MinorsCannotApply, RejectReason}

object SignUpApplicablePolicy {
  def check(
             birth: BirthDateForSignUpApplicableCheck,
             card: () => CreditCardVerificationResult,
             user: () => SameUserForSignUpApplicableCheck
             ): Either[RejectReason, Unit] = {
    if (birth == Minors) Left(MinorsCannotApply)
    else if (card() == Invalid) Left(InvalidCreditCard)
    else if (user() == Exist) Left(AlreadyApplied)
    else Right()
  }
}
