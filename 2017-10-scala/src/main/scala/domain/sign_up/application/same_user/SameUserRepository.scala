package domain.sign_up.application.same_user

trait SameUserRepository {
  def exists(sameUser: SameUser): SameUserForSignUpApplicableCheck
}
