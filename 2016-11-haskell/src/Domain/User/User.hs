module Domain.User.User where

import Domain.User.BirthDate

import Domain.User.PreContractUser
import Domain.User.ContractedUser
import qualified Domain.User.ContractRejectReason as R

import Domain.CreditCard.ExaminedCreditCard

isContractable :: PreContractUser -> [ContractedUser] -> ExaminedCreditCard -> Maybe R.ContractRejectReason
isContractable _    _      (InvalidCreditCard _ _ _) = Just R.InvalidCreditCard
isContractable self []     _                         = if isAdult $ Domain.User.PreContractUser.birthDate self then Nothing else Just R.NonAdult
isContractable _    others _                         = Just R.AlreadyContracted
