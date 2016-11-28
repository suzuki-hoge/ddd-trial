module Domain.User.UserSpec where

import Test.Hspec

import Domain.User.User
import Domain.User.Course
import qualified Domain.User.ContractRejectReason as R

import qualified Domain.User.PreContractUserFixture as PreContractUserF
import qualified Domain.User.ContractedUserFixture as ContractedUserF
import qualified Domain.User.BirthDateFixture as BirthDateF

import qualified Domain.CreditCard.ExaminedCreditCardFixture as ExaminedCreditCardF

spec :: Spec
spec = do
    let adultUser = PreContractUserF.construct ("john", "doe") BirthDateF.adult
    let childUser = PreContractUserF.construct ("john", "doe") BirthDateF.child

    let contracted = ContractedUserF.construct ("john", "doe") Basic BirthDateF.adult

    let validCreditCard = ExaminedCreditCardF.valid
    let invalidCreditCard = ExaminedCreditCardF.invalid

    describe "isContractable" $ do
        it "with invalid credit card is not contractable" $ do
            isContractable adultUser []               invalidCreditCard `shouldBe` Just R.InvalidCreditCard

        it "child is not contractable" $ do
            isContractable childUser []               validCreditCard   `shouldBe` Just R.NonAdult

        it "already contracted user is not contractable" $ do
            isContractable adultUser [contracted] validCreditCard   `shouldBe` Just R.AlreadyContracted

        it "else contractable" $ do
            isContractable adultUser []               validCreditCard   `shouldBe` Nothing
