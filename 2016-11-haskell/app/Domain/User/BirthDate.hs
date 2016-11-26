module Domain.User.BirthDate where

data BirthDate = BirthDate { value :: String } deriving Show

isAdult :: BirthDate -> Bool
isAdult birthDate = value birthDate < "20000101"
