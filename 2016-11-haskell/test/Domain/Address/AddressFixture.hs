module Domain.Address.AddressFixture where

import Domain.Address.Address
import Domain.Address.PostalCode
import Domain.Address.Street

get = Address (PostalCode "111-2222") (Street "foo st")
