package api.user.refer

import api.validation.ValidationError
import domain.user.refer.ReferredUser

case class UserReferResponse(params: Seq[(String, String)]) {
  def toJson = "halfhearted..."
}

object UserReferResponse {
  def validationError(validationError: ValidationError): UserReferResponse = {
    UserReferResponse(
      List(("error_reason", "validation_error"), ("error_message", validationError.message))
    )
  }

  def authenticationError(): UserReferResponse = {
    UserReferResponse(
      List(("error_reason", "authentication_error"))
    )
  }

  def success(referredUser: ReferredUser): UserReferResponse = {
    UserReferResponse(
      List(("name", referredUser.userName.value), ("credit_card_number", referredUser.maskedCreditCardNumber.value))
    )
  }
}
