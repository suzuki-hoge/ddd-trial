package domain.admit.application.same_user

sealed trait SameUserForAdmitApplicableCheck

case object Exist extends SameUserForAdmitApplicableCheck

case object NotExist extends SameUserForAdmitApplicableCheck