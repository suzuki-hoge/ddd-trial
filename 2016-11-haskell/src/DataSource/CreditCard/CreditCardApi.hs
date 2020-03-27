module DataSource.CreditCard.CreditCardApi where

import Domain.CreditCard.UnexaminedCreditCard
import Domain.CreditCard.ExamineResult
import Domain.CreditCard.Expiration

examination :: UnexaminedCreditCard -> IO ExamineResult
examination card = return $ case card of
        (UnexaminedCreditCard _ (Expiration "10/26") _) -> Valid
        _                                               -> Invalid
