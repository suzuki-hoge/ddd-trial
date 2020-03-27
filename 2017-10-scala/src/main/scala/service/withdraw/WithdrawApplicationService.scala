package service.withdraw

import domain.withdraw.application.WithdrawApplication

object WithdrawApplicationService {
  def apply(app: WithdrawApplication): Unit = {
    val user = WithdrawUserRepositoryImpl.findWithdraw(app.id).apply("2017")
    WithdrawUserRepositoryImpl.withdraw(user)
  }
}

