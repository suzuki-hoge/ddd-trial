module Domain.CreditCard.CreditCardSpec where

import Test.Hspec

import Domain.CreditCard.CreditCard

import qualified Domain.CreditCard.ExaminedCreditCardFixture as ExaminedCreditCardF
import qualified Domain.CreditCard.UnexaminedCreditCardFixture as UnexaminedCreditCardF
import qualified Domain.CreditCard.ExamineResult as Result

spec :: Spec
spec = do
    describe "toExamined" $ do
        it "if examine result is valid, then credit card is valid" $ do
            toExamined UnexaminedCreditCardF.valid Result.Valid `shouldBe` ExaminedCreditCardF.valid

        it "if examine result is invalid, then credit card is invalid" $ do
            toExamined UnexaminedCreditCardF.invalid Result.Invalid `shouldBe` ExaminedCreditCardF.invalid
