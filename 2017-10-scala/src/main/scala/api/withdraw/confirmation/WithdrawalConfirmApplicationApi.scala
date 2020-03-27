package api.withdraw.confirmation

import api.withdraw.confirmation.form.WithdrawalConfirmApplicationForm
import domain.withdraw.error.{AlreadyWithdrawn, RejectReason}
import domain.withdraw.user.WithdrawUser
import service.withdraw.WithdrawalConfirmApplicationService

object WithdrawalConfirmApplicationApi {
  def apply(id: String): Either[String, WithdrawUser] = for {
    app <- WithdrawalConfirmApplicationForm.bind(id).right
    res <- WithdrawalConfirmApplicationService.apply(app).left.map(error).right
  } yield res

  private def error(rejectReason: RejectReason): String = rejectReason match {
    case AlreadyWithdrawn => "BusinessError already withdrawn"
  }
}
