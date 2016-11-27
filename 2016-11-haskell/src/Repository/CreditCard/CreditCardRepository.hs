module Repository.CreditCard.CreditCardRepository where

import Domain.CreditCard.CreditCard

import Domain.CreditCard.UnexaminedCreditCard
import Domain.CreditCard.ExaminedCreditCard
import Domain.CreditCard.ExamineResult

import qualified DataSource.CreditCard.CreditCardApi as Api

examination :: UnexaminedCreditCard -> IO ExaminedCreditCard
examination unexamined = do
    result <- Api.examination unexamined
    return $ toExamined unexamined result
