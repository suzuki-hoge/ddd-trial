module Repository.User.UserRepositorySpec where

import Test.Hspec

import Repository.User.UserRepository
import Domain.User.Password
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
    let sameUser  = PreContractUserF.construct ("jane", "doe") BirthDateF.adult

    let validCreditCard = ExaminedCreditCardF.valid
    let invalidCreditCard = ExaminedCreditCardF.invalid

    describe "checkContractable" $ do
        it "with invalid credit card is not contractable" $ do
            checkContractable adultUser invalidCreditCard `shouldReturn` Just R.InvalidCreditCard

        it "child is not contractable" $ do
            checkContractable childUser validCreditCard `shouldReturn` Just R.NonAdult

        it "already contracted user is not contractable" $ do
            checkContractable sameUser validCreditCard   `shouldReturn` Just R.AlreadyContracted

        it "else contractable" $ do
            checkContractable adultUser validCreditCard `shouldReturn` Nothing

    let contracted = ContractedUserF.construct ("john", "doe") Basic BirthDateF.adult

    let password = Password "pw-123"

    describe "contract" $ do
        it "allocate id and password, and user is inserted" $ do
            contract adultUser `shouldReturn` (contracted, password)
