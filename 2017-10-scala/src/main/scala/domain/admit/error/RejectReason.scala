package domain.admit.error

sealed trait RejectReason

case object MinorsCannotApply extends RejectReason

case object InvalidCreditCard extends RejectReason

case object AlreadyAdmitted extends RejectReason
