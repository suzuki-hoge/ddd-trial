module DataSource.CreditCard.CreditCardApiSpec where

import Test.Hspec

import DataSource.CreditCard.CreditCardApi

import qualified Domain.CreditCard.UnexaminedCreditCardFixture as UnexaminedCreditCardF
import qualified Domain.CreditCard.ExamineResult as Result

spec :: Spec
spec = do
    describe "examination" $ do
        it "not expirationed credit card is get valid" $ do
            examination UnexaminedCreditCardF.valid `shouldReturn` Result.Valid

        it "expirationed credit card is get invalid" $ do
            examination UnexaminedCreditCardF.invalid `shouldReturn` Result.Invalid
