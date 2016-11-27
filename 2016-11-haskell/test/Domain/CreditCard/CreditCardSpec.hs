module Domain.CreditCard.CreditCardSpec where

import Test.Hspec

import Domain.CreditCard.CreditCard

import qualified Domain.CreditCard.ExaminedCreditCardFixture as ExaminedCreditCardF
import qualified Domain.CreditCard.UnexaminedCreditCardFixture as UnexaminedCreditCardF
import qualified Domain.CreditCard.ExamineResultFixture as ExamineResultF

spec :: Spec
spec = do
    describe "toExamined" $ do
        it "if examine result is valid, then credit card is valid" $ do
            toExamined UnexaminedCreditCardF.get ExamineResultF.valid `shouldBe` ExaminedCreditCardF.valid

        it "if examine result is invalid, then credit card is invalid" $ do
            toExamined UnexaminedCreditCardF.get ExamineResultF.invalid `shouldBe` ExaminedCreditCardF.invalid
