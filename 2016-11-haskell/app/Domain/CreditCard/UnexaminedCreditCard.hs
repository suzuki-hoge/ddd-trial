module Domain.CreditCard.UnexaminedCreditCard where

import Domain.CreditCard.Number
import Domain.CreditCard.Expiration
import Domain.CreditCard.SecurityCode

data UnexaminedCreditCard = UnexaminedCreditCard { number       :: Number
                                                 , expiration   :: Expiration
                                                 , securityCode :: SecurityCode
                                                 } deriving Show
