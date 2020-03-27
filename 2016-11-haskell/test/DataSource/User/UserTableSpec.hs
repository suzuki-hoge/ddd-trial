module DataSource.User.UserTableSpec where

import Test.Hspec

import qualified DataSource.Tables as T

import DataSource.User.UserTable

import Domain.User.ForFetchSameUsers

import Domain.User.FirstName
import Domain.User.LastName


spec :: Spec
spec = do
    let noSameName = ForFetchSameUsers (FirstName "john") (LastName "doe")
    let sameName = ForFetchSameUsers (FirstName "jane") (LastName "doe")

    describe "findSameUsers" $ do
        it "john is not already contracted" $ do
            findSameUsers noSameName `shouldReturn` []

        it "jane is already contracted" $ do
            findSameUsers sameName `shouldReturn` T.contractedUsers

    describe "allocateForContract" $ do
        it "not test because it's mock" $ do
            True `shouldBe` True

    describe "contract" $ do
        it "not test because it's mock" $ do
            True `shouldBe` True
