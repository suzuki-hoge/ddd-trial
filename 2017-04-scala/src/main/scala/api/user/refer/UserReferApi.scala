package api.user.refer

import api.authentication.form.PasswordForm
import api.user.refer.form.UserIdForm
import api.validation.ValidationError
import domain.user.UserId
import domain.user.register.Password
import service.authentication.AuthenticationService
import service.user.refer.UserReferService

case class UserReferApi(authenticationService: AuthenticationService, userReferService: UserReferService) {
  def refer(
             userIdString: String,
             passwordString: String
             ): UserReferResponse = {
    val validated: Either[ValidationError, (UserId, Password)] = for {
      userId <- UserIdForm.bind(userIdString)
      password <- PasswordForm.bind(passwordString)
    } yield (userId, password)

    validated match {
      case Left(ve) => UserReferResponse.validationError(ve)
      case Right((id, ps)) => authenticationService.isValid(id, ps) match {
        case false => UserReferResponse.authenticationError()
        case _ => UserReferResponse.success(userReferService.refer(id))
      }
    }
  }
}
