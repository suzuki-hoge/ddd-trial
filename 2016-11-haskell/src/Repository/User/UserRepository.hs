module Repository.User.UserRepository where

import Domain.User.User
import Domain.User.PreContractUser
import Domain.User.ContractedUser
import qualified Domain.User.ContractRejectReason as R
import Domain.User.ForFetchSameUsers
import Domain.User.Password

import Domain.CreditCard.ExaminedCreditCard

import qualified DataSource.User.UserTable as Table

checkContractable :: PreContractUser -> ExaminedCreditCard -> IO (Maybe R.ContractRejectReason)
checkContractable pre creditCard = do
    others <- Table.findSameUsers $ forFetchSameUsers pre
    return $ isContractable pre others creditCard

contract :: PreContractUser -> IO (ContractedUser, Password)
contract pre = do
    (userId, password) <- Table.allocateForContract
    contracted <- Table.contract userId pre
    return (contracted, password)
