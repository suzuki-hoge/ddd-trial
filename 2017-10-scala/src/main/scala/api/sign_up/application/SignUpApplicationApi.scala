package api.sign_up.application

import api.sign_up.application.form.SignUpApplicationForm
import domain.authentication.UserPassword
import domain.core.user.UserId
import domain.sign_up.error.{AlreadyApplied, InvalidCreditCard, MinorsCannotApply, RejectReason}
import service.sign_up.SignUpApplicationService.Service

object SignUpApplicationApi {
  type S = String

  def apply(name: S, address: S, birth: S, mail: S, card: S, service: Service): Either[String, (UserId, UserPassword)] = for {
    app <- SignUpApplicationForm.bind(name, address, birth, mail, card).left.map("ValidationError " ++ _).right
    res <- service(app).left.map(error).right
  } yield res

  private def error(rejectReason: RejectReason): String = rejectReason match {
    case MinorsCannotApply => "BusinessError minors cannot apply"
    case InvalidCreditCard => "BusinessError invalid credit card"
    case AlreadyApplied => "BusinessError already applied"
  }
}
