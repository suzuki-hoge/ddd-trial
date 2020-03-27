package domain.withdraw.user

import domain.core.user.UserId
import domain.withdraw.application.WithdrawApplicationDateTime

case class WithdrawnUser(id: UserId, at: WithdrawApplicationDateTime)
