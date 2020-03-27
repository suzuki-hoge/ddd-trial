package entry_application.service

import entry_application.data_source.{EntryApplicationCreditCardRepositoryImpl, EntryApplicationUserRepositoryImpl}
import entry_application.domain.{EntryCheckApplication, EntryCheckError, EntryCheckPolicy}
import scalaz.{EitherT, Failure, OptionT, \/}

import scala.util.Try

object EntryCheckApplicationService {
  def entryCheck(app: EntryCheckApplication): EitherT[Try, EntryCheckError, Unit] = {
//    val checked: Try[\/[EntryCheckError, Unit]] = Failure(new RuntimeException())

//    val checked: Try[Either[EntryCheckError, Unit]] = for {
//      exists <- EntryApplicationUserRepositoryImpl.exists(app.name)
//      isValid <- EntryApplicationCreditCardRepositoryImpl.isValid(app.number)
//    } yield EntryCheckPolicy.check(exists, app.birthDate, isValid)
//
//    EitherT.fromEither(checked)

    val optList = List(1,2,3).liftM[OptionT]

    ???
  }
}
