module Domain.CreditCard.CreditCard where

import Domain.CreditCard.ExaminedCreditCard
import Domain.CreditCard.UnexaminedCreditCard
import Domain.CreditCard.ExamineResult as Result

toExamined :: UnexaminedCreditCard -> ExamineResult -> ExaminedCreditCard
toExamined (UnexaminedCreditCard number expiration securityCode) result = case result of
    Result.Valid   -> ValidCreditCard   number expiration securityCode
    Result.Invalid -> InvalidCreditCard number expiration securityCode
