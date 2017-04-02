package domain.user.register.same_user_validation

trait SameUserValidationRepository {
  def isValid(sameUserValidation: SameUserValidation): Either[AlreadyRegistered, Unit]
}
