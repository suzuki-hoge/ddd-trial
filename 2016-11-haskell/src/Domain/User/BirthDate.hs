module Domain.User.BirthDate where

data BirthDate = BirthDate { value :: String } deriving (Show, Eq)

isAdult :: BirthDate -> Bool
isAdult birthDate = value birthDate < "20000101"
