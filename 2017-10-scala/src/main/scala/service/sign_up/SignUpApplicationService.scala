package service.sign_up

import domain.authentication.{AuthenticationRepository, UserPassword}
import domain.core.credit_card.{CreditCard, CreditCardRepository, CreditCardVerificationResult, Valid}
import domain.core.user.UserId
import domain.sign_up.application.same_user.{NotExist, SameUser, SameUserForSignUpApplicableCheck, SameUserRepository}
import domain.sign_up.application.{SignUpApplicablePolicy, SignUpApplication}
import domain.sign_up.error.RejectReason

object SignUpApplicationService {
  type Service = SignUpApplication => Either[RejectReason, (UserId, UserPassword)]

  def apply: Service = app => {
    SignUpApplicablePolicy.check(
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
  def exists(sameUser: SameUser): SameUserForSignUpApplicableCheck = {
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
