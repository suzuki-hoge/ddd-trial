module Domain.Address.Address where

import Domain.Address.PostalCode
import Domain.Address.Street

data Address = Address { postalCode :: PostalCode
                       , street     :: Street
                       } deriving Show
