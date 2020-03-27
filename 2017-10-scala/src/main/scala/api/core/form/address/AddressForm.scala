package api.core.form.address

import domain.core.address.Address

object AddressForm {
  def bind(value: String): Either[String, Address] = value match {
    case "" => Left("[AddressForm]: not empty")
    case x => Right(Address(x))
  }
}
