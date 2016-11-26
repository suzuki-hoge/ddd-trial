module Domain.User.ForFetchSameUsers where

import Domain.User.FirstName
import Domain.User.LastName

data ForFetchSameUsers = ForFetchSameUsers { firstName :: FirstName
                                           , lastName  :: LastName
                                           } deriving Show
