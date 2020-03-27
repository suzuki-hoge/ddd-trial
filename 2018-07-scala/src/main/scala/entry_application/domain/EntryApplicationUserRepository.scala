package entry_application.domain

import core.domain.user.{UserId, UserName}

import scala.util.Try

trait EntryApplicationUserRepository {
  def exists(name: UserName): Try[Boolean]

  def entry(app: EntryUserApplication): Try[UserId]
}
