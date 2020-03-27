package domain.user.refer

import domain.user.UserId

trait UserReferRepository {
  def find(userId: UserId): ReferredUser
}
