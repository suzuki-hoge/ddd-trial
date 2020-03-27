module DataSource.User.UserTable where

import qualified DataSource.Tables as T
import qualified DataSource.Sequences as S

import Domain.User.PreContractUser as Pre
import Domain.User.ContractedUser as User
import Domain.User.ForFetchSameUsers as For
import Domain.User.FirstName
import Domain.User.LastName
import Domain.User.Course
import Domain.User.UserId
import Domain.User.Password

findSameUsers :: ForFetchSameUsers -> IO [ContractedUser]
findSameUsers for = return $ filter (isSame for) T.contractedUsers
    where
        isSame :: ForFetchSameUsers -> ContractedUser -> Bool
        isSame for contracted = isSameFirstName && isSameLastName
            where
                isSameFirstName = For.firstName for == User.firstName contracted
                isSameLastName = For.lastName for == User.lastName contracted

allocateForContract :: IO (UserId, Password)
allocateForContract = return (S.userId, S.password)

contract :: UserId -> PreContractUser -> IO ContractedUser
contract id pre = return $ ContractedUser id (Pre.firstName pre) (Pre.lastName pre) Basic (Pre.gender pre) (Pre.birthDate pre) (Pre.address pre) (Pre.phoneNumber pre) (Pre.mailAddress pre)
