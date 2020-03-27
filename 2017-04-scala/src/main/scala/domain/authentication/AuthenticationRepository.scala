package domain.authentication

import domain.user.UserId
import domain.user.register.Password

trait AuthenticationRepository {
  def isValid(userId: UserId, password: Password): Boolean
}
