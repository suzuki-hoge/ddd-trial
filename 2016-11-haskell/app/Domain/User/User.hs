module Domain.User.User where

import Domain.User.BirthDate

import Domain.CreditCard.ExaminedCreditCard

import Domain.User.PreContractUser
import Domain.User.ContractedUser

isContractable :: PreContractUser -> [ContractedUser] -> ExaminedCreditCard -> Bool
isContractable _    _      (InvalidCreditCard _ _ _) = False
isContractable self []     _                         = isAdult $ Domain.User.PreContractUser.birthDate self
isContractable _    others _                         = False
