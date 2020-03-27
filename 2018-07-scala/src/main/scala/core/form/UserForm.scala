package core.form

import core.domain.user.{UserBirthDate, UserGender, UserName}
import scalaz.Scalaz._
import scalaz.ValidationNel

object UserNameForm {
  def apply(s: String): ValidationNel[String, UserName] = s match {
    case v if List("applicable", "same user exists", "system error").contains(v) => UserName(s).successNel
    case _ => "Invalid value on UserNameForm".failureNel
  }
}

object UserBirthDateForm {
  def apply(s: String): ValidationNel[String, UserBirthDate] = s match {
    case "applicable" => UserBirthDate(s).successNel
    case _ => "Invalid value on UserBirthDateForm".failureNel
  }
}

object UserGenderForm {
  def apply(s: String): ValidationNel[String, UserGender] = s match {
    case "applicable" => UserGender(s).successNel
    case _ => "Invalid value on UserGenderForm".failureNel
  }
}
