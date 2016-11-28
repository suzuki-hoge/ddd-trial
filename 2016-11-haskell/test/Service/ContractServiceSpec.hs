module Service.ContractServiceSpec where

import Test.Hspec

import Service.ContractService

import Domain.User.UserId
import Domain.User.Password
import qualified Domain.User.ContractRejectReason as R

import qualified Domain.User.PreContractUserFixture as PreContractUserF
import qualified Domain.User.BirthDateFixture as BirthDateF

import qualified Domain.CreditCard.UnexaminedCreditCardFixture as UnexaminedCreditCardF

spec :: Spec
spec = do
    let pre = PreContractUserF.construct ("john", "doe") BirthDateF.adult

    let validCreditCard = UnexaminedCreditCardF.valid
    let invalidCreditCard = UnexaminedCreditCardF.invalid

    let userId = UserId "id-123"
    let password = Password "pw-123"

    describe "apply" $ do
        it "if contract is successfully, return id and password" $ do
            apply pre validCreditCard `shouldReturn` Right (userId, password)

        it "if contract is failured, return reject reason" $ do
            apply pre invalidCreditCard `shouldReturn` Left R.InvalidCreditCard
