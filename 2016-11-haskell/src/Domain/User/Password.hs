module Domain.User.Password where

data Password = Password { value :: String } deriving (Show, Eq)
