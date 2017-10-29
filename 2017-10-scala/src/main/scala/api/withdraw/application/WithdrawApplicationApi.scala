package api.withdraw.application

import api.withdraw.application.form.WithdrawApplicationForm
import domain.withdraw.error.{AlreadyWithdrawn, RejectReason}
import service.withdraw.{WithdrawApplicationService, WithdrawalConfirmApplicationService}

object WithdrawApplicationApi {
  def apply(id: String): Either[String, Unit] = for {
    app <- WithdrawApplicationForm.bind(id).right
    _ <- WithdrawalConfirmApplicationService.apply(app.asConfirmApplication()).left.map(error).right
    _ <- Right(WithdrawApplicationService.apply(app)).left.map(_.toString).right // todo ???
  } yield Unit

  private def error(rejectReason: RejectReason): String = rejectReason match {
    case AlreadyWithdrawn => "BusinessError already withdrawn"
  }
}
