package domain.sign_up.user

trait AppliedUserRepository {
  def apply(user: AppliedUser): Unit
}
