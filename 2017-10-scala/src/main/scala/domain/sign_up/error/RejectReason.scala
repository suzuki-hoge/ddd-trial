package domain.sign_up.error

sealed trait RejectReason

case object MinorsCannotApply extends RejectReason

case object InvalidCreditCard extends RejectReason

case object AlreadyApplied extends RejectReason
