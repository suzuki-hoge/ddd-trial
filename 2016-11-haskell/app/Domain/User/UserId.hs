module Domain.User.UserId where

data UserId = UserId { value :: String } deriving (Show, Eq)
