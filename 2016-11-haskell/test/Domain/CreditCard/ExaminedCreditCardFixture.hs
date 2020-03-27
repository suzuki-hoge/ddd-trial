module Domain.CreditCard.ExaminedCreditCardFixture where

import Domain.CreditCard.ExaminedCreditCard

import Domain.CreditCard.Number
import Domain.CreditCard.Expiration
import Domain.CreditCard.SecurityCode

valid   = ValidCreditCard   (Number "1111-2222-3333-4444") (Expiration "10/26") (SecurityCode "123")
invalid = InvalidCreditCard (Number "1111-2222-3333-4444") (Expiration "10/16") (SecurityCode "123")
