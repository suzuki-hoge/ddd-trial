package domain.sign_up.application.same_user

sealed trait SameUserForSignUpApplicableCheck

case object Exist extends SameUserForSignUpApplicableCheck

case object NotExist extends SameUserForSignUpApplicableCheck
