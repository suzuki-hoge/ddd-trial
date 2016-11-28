module Service.ContractService where

import Domain.User.ContractedUser as Contracted
import Domain.User.PreContractUser
import Domain.User.UserId
import Domain.User.Password
import Domain.User.ContractRejectReason

import Domain.CreditCard.UnexaminedCreditCard

import Repository.User.UserRepository
import Repository.CreditCard.CreditCardRepository

type Allocated = (UserId, Password)

apply :: PreContractUser -> UnexaminedCreditCard -> IO (Either ContractRejectReason Allocated)
apply pre unexaminated = do
    examinated <- examination unexaminated
    reason <- checkContractable pre examinated

    case reason of
        Nothing -> do
            (contracted, password) <- contract pre
            return $ Right (Contracted.userId contracted, password)

        (Just reason') -> do
            return $ Left reason'
