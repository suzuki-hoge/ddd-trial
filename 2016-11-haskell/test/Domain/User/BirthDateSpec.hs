module Domain.User.BirthDateSpec where

import Test.Hspec

import Domain.User.BirthDate

import qualified Domain.User.BirthDateFixture as BirthDateF

spec :: Spec
spec = do
    describe "isAdult" $ do
        it "person that born in 1990 is adult" $ do
            isAdult BirthDateF.adult `shouldBe` True

        it "person that born in 2010 is child" $ do
            isAdult BirthDateF.child `shouldBe` False
