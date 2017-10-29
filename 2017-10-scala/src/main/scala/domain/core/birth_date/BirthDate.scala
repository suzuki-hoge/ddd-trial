package domain.core.birth_date

case class BirthDate(year: Int) {
  def isMinors(now: Int):Boolean = now - year < 20
}
