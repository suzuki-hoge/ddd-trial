package domain.admit.application.same_user

trait SameUserRepository {
  def exists(sameUser: SameUser): SameUserForAdmitApplicableCheck
}
