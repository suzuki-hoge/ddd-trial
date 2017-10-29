package domain.withdraw.application

import domain.withdraw.error.{AlreadyWithdrawn, RejectReason}
import domain.withdraw.user.WithdrawnUser

object WithdrawApplicablePolicy {
  def check(user: () => Option[WithdrawnUser]): Either[RejectReason, Unit] = {
    if (user().nonEmpty) Left(AlreadyWithdrawn)
    else Right()
  }
}
