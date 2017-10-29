package domain.withdraw.user

import domain.core.user.UserId

trait WithdrawUserRepository {
  def findWithdraw(id: UserId): WithdrawUser

  def withdraw(user: WithdrawnUser): Unit

  def findWithdrawn(id: UserId): Option[WithdrawnUser]
}
