module Domain.User.ForFetchSameUsersFixture where

import Domain.User.ForFetchSameUsers

import Domain.User.FirstName
import Domain.User.LastName

get = ForFetchSameUsers (FirstName "john") (LastName "doe")
