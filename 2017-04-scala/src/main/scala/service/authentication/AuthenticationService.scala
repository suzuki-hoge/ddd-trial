package service.authentication

import domain.authentication.AuthenticationRepository
import domain.user.UserId
import domain.user.register.Password

case class AuthenticationService(repository: AuthenticationRepository) {
  def isValid(userId: UserId, password: Password): Boolean = {
    repository.isValid(userId, password)
  }
}
