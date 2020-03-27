package domain.withdraw.application

import domain.core.user.UserId
import domain.withdraw.confirmation.WithdrawalConfirmApplication

case class WithdrawApplication(id: UserId) {
  def asConfirmApplication(): WithdrawalConfirmApplication = {
    WithdrawalConfirmApplication(id)
  }
}
