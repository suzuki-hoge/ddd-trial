package api.core.form.birth_date

import domain.core.birth_date.BirthDate

object BirthDateForm {
  def bind(value: String): Either[String, BirthDate] = value match {
    case "" => Left("[BirthDateForm]: not empty")
    case x => Right(BirthDate(x.toInt))
  }
}
