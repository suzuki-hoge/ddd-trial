package api.withdraw.application.form

import api.core.user.form.UserIdForm
import domain.withdraw.application.WithdrawApplication

object WithdrawApplicationForm {
  def bind(id: String): Either[String, WithdrawApplication] = {
    UserIdForm.bind(id).right.map(WithdrawApplication)
  }
}
