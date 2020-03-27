package domain.user

import domain.user.register.InvalidAge

case class Age(value: Int) {
  def isAdult: Either[InvalidAge, Unit] = value match {
    case x if x > 19 => Right()
    case _ => Left(InvalidAge(value))
  }
}
