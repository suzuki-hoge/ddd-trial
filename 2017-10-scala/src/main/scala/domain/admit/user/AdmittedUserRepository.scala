package domain.admit.user

trait AdmittedUserRepository {
  def apply(user: AdmittedUser): Unit
}
