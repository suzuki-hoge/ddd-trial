package service.user.refer

import domain.user.UserId
import domain.user.refer.{ReferredUser, UserReferRepository}

case class UserReferService(repository: UserReferRepository) {
  def refer(userId: UserId): ReferredUser = {
    repository.find(userId)
  }
}
