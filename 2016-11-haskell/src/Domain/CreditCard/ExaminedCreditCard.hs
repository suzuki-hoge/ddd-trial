module Domain.CreditCard.ExaminedCreditCard where

import Domain.CreditCard.Number
import Domain.CreditCard.Expiration
import Domain.CreditCard.SecurityCode

data ExaminedCreditCard = ValidCreditCard { number       :: Number
                                          , expiration   :: Expiration
                                          , securityCode :: SecurityCode
                                          } |
                        InvalidCreditCard { number       :: Number
                                          , expiration   :: Expiration
                                          , securityCode :: SecurityCode
                                          } deriving (Show, Eq)
