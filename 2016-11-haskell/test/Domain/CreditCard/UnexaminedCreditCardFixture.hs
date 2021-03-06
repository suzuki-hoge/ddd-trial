module Domain.CreditCard.UnexaminedCreditCardFixture where

import Domain.CreditCard.UnexaminedCreditCard

import Domain.CreditCard.Number
import Domain.CreditCard.Expiration
import Domain.CreditCard.SecurityCode

valid =   UnexaminedCreditCard (Number "1111-2222-3333-4444") (Expiration "10/26") (SecurityCode "123")
invalid = UnexaminedCreditCard (Number "1111-2222-3333-4444") (Expiration "10/16") (SecurityCode "123")
