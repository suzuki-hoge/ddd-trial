module Domain.User.PreContractUserSpec where

import Test.Hspec

import Domain.User.PreContractUser

import qualified Domain.User.PreContractUserFixture as PreContractUserF
import qualified Domain.User.ForFetchSameUsersFixture as ForFetchSameUsersF
import qualified Domain.User.BirthDateFixture as BirthDateF

spec :: Spec
spec = do
    let user = PreContractUserF.construct ("john", "doe") BirthDateF.adult

    describe "forFetchSameUsers" $ do
        it "same user is fetched by first name and last name" $ do
            forFetchSameUsers user `shouldBe` ForFetchSameUsersF.get
