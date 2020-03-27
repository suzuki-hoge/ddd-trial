package service.withdraw

import domain.core.user.UserId
import domain.withdraw.application.WithdrawApplicablePolicy
import domain.withdraw.confirmation.WithdrawalConfirmApplication
import domain.withdraw.error.RejectReason
import domain.withdraw.user.{WithdrawUser, WithdrawUserRepository, WithdrawnUser}

object WithdrawalConfirmApplicationService {
  def apply(app: WithdrawalConfirmApplication): Either[RejectReason, WithdrawUser] = {
    WithdrawApplicablePolicy.check(
      () => WithdrawUserRepositoryImpl.findWithdrawn(app.id)
    ).right.map(
        unit => WithdrawUserRepositoryImpl.findWithdraw(app.id)
      )
  }
}

object WithdrawUserRepositoryImpl extends WithdrawUserRepository {
  def findWithdraw(id: UserId): WithdrawUser = {
    ???
  }

  def withdraw(user: WithdrawnUser): Unit = {
    ???
  }

  def findWithdrawn(id: UserId): Option[WithdrawnUser] = {
    ???
  }
}
