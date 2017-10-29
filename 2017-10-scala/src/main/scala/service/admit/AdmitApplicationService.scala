package service.admit

import domain.authentication.{AuthenticationRepository, UserPassword}
import domain.core.credit_card.{CreditCard, CreditCardRepository, CreditCardVerificationResult, Valid}
import domain.core.user.UserId
import domain.admit.application.same_user.{NotExist, SameUser, SameUserForAdmitApplicableCheck, SameUserRepository}
import domain.admit.application.{AdmitApplicablePolicy, AdmitApplication}
import domain.admit.error.RejectReason

object AdmitApplicationService {
  type Service = AdmitApplication => Either[RejectReason, (UserId, UserPassword)]

  def apply: Service = app => {
    AdmitApplicablePolicy.check(
      app.birthDate(2017),
      () => CreditCardRepositoryImpl.verify(app.card),
      () => SameUserRepositoryImpl.exists(app.sameUser())
    ).right.map(
        unit => AuthenticationRepositoryImpl.allocate()
      )
  }
}

object CreditCardRepositoryImpl extends CreditCardRepository {
  def verify(creditCard: CreditCard): CreditCardVerificationResult = {
    Valid
  }
}

object SameUserRepositoryImpl extends SameUserRepository {
  def exists(sameUser: SameUser): SameUserForAdmitApplicableCheck = {
    NotExist
  }
}

object AuthenticationRepositoryImpl extends AuthenticationRepository {
  def allocate(): (UserId, UserPassword) = {
    (UserId("1"), UserPassword("1"))
  }

  def authenticate(userId: UserId, userPassword: UserPassword): Either[String, Unit] = {
    Right()
  }
}
