module Domain.CreditCard.CreditCard where

import Domain.CreditCard.ExaminedCreditCard
import Domain.CreditCard.UnexaminedCreditCard
import Domain.CreditCard.ExamineResult

toExamined :: UnexaminedCreditCard -> ExamineResult -> ExaminedCreditCard
toExamined (UnexaminedCreditCard number expiration securityCode) result = case result of
    (ExamineResult True)  -> ValidCreditCard   number expiration securityCode
    (ExamineResult False) -> InvalidCreditCard number expiration securityCode
