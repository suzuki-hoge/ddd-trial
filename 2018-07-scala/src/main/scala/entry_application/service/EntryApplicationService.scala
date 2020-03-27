package entry_application.service

import core.domain.user.UserId
import entry_application.data_source.{EntryApplicationCreditCardRepositoryImpl, EntryApplicationUserRepositoryImpl}
import entry_application.domain.EntryApplication

import scala.util.Try

object EntryApplicationService {
  def entry(app: EntryApplication): Try[UserId] = for {
    // _ <- EntryCheckApplicationService.entryCheck(app.forCheck)

    userId <- EntryApplicationUserRepositoryImpl.entry(app.forUser)
    _ <- EntryApplicationCreditCardRepositoryImpl.entry(userId, app.forCreditCard)
  } yield userId
}
