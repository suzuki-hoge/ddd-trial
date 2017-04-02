object Main {

  def main(args: Array[String]): Unit = {
    val name = "john"

    val r: Either[RegistrationError, AppliedUser] = for {
      age <- check().left.map(_.toRegistrationError).right
    } yield AppliedUser(name)

    println(r)
  }

  def check(): Either[InvalidAge, Unit] = {
    Left(InvalidAge(18))
  }
}

case class InvalidAge(age: Int) {
  def toRegistrationError: RegistrationError = RegistrationError(age.toString ++ " is invalid")
}

case class RegistrationError(message: String)

case class AppliedUser(name: String)
