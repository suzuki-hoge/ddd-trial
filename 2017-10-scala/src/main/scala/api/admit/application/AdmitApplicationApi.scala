package api.admit.application

import api.admit.application.form.AdmitApplicationForm
import domain.authentication.UserPassword
import domain.core.user.UserId
import domain.admit.error.{AlreadyAdmitted, InvalidCreditCard, MinorsCannotApply, RejectReason}
import service.admit.AdmitApplicationService.Service

object AdmitApplicationApi {
  type S = String

  def apply(name: S, address: S, birth: S, mail: S, card: S, service: Service): Either[String, (UserId, UserPassword)] = for {
    app <- AdmitApplicationForm.bind(name, address, birth, mail, card).left.map("ValidationError " ++ _).right
    res <- service(app).left.map(error).right
  } yield res

  private def error(rejectReason: RejectReason): String = rejectReason match {
    case MinorsCannotApply => "BusinessError minors cannot apply"
    case InvalidCreditCard => "BusinessError invalid credit card"
    case AlreadyAdmitted => "BusinessError already admitted"
  }
}
