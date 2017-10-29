package domain.withdraw.error

sealed trait RejectReason

case object AlreadyWithdrawn extends RejectReason
