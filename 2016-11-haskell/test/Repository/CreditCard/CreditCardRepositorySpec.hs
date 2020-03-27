module Repository.CreditCard.CreditCardRepositorySpec where

import Test.Hspec

import Repository.CreditCard.CreditCardRepository

import qualified Domain.CreditCard.ExaminedCreditCardFixture as ExaminedCreditCardF
import qualified Domain.CreditCard.UnexaminedCreditCardFixture as UnexaminedCreditCardF

spec :: Spec
spec = do
    describe "examination" $ do
        it "not expirationed credit card is valid credit card" $ do
            examination UnexaminedCreditCardF.valid `shouldReturn` ExaminedCreditCardF.valid

        it "expirationed credit card is invalid credit card" $ do
            examination UnexaminedCreditCardF.invalid `shouldReturn` ExaminedCreditCardF.invalid
