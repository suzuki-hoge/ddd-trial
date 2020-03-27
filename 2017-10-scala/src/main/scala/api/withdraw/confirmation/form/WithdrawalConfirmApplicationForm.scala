package api.withdraw.confirmation.form

import api.core.user.form.UserIdForm
import domain.withdraw.confirmation.WithdrawalConfirmApplication

object WithdrawalConfirmApplicationForm {
  def bind(id: String): Either[String, WithdrawalConfirmApplication] = {
    UserIdForm.bind(id).right.map(WithdrawalConfirmApplication)
  }
}
