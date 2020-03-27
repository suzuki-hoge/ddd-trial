package domain.user.register

import domain.user.UserId

trait UserRegisterRepository {
  def register(appliedUser: AppliedUser): (UserId, Password)
}
