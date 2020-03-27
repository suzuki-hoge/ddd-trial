package entry_application.data_source

import core.domain.user.{UserGender, UserId, UserName}
import entry_application.domain.{EntryApplicationUserRepository, EntryUserApplication}

import scala.util.{Failure, Success, Try}

object EntryApplicationUserRepositoryImpl extends EntryApplicationUserRepository {
  override def exists(name: UserName): Try[Boolean] = name.v match {
    case "applicable" => Success(false)
    case "same user exists" => Success(true)
    case "system error" => Failure(new RuntimeException("database connection error"))
  }

  override def entry(app: EntryUserApplication): Try[UserId] = {
    Success(saveSomething(app.name.v, app.gender))
  }

  private def saveSomething(name: String, gender: String): UserId = {
    UserId("1")
  }

  implicit private def toSystemValue(gender: UserGender): String = if (gender.v == "applicable") "M" else "F"
}
