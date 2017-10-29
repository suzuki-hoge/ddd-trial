package domain.authentication

import domain.core.user.UserId

trait AuthenticationRepository {
  def allocate(): (UserId, UserPassword)

  def authenticate(userId: UserId, userPassword: UserPassword): Either[String, Unit]
}
