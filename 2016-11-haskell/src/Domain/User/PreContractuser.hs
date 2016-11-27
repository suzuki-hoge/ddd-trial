module Domain.User.PreContractUser where

import Domain.User.FirstName
import Domain.User.LastName
import Domain.User.Course
import Domain.User.Gender
import Domain.User.BirthDate

import Domain.Address.Address

import Domain.Phone.PhoneNumber

import Domain.Mail.MailAddress

import Domain.User.ForFetchSameUsers

data PreContractUser = PreContractUser { firstName   :: FirstName
                                       , lastName    :: LastName
                                       , course      :: Course
                                       , gender      :: Gender
                                       , birthDate   :: BirthDate
                                       , address     :: Address
                                       , phoneNumber :: PhoneNumber
                                       , mailAddress :: MailAddress
                                       } deriving Show

forFetchSameUsers :: PreContractUser -> ForFetchSameUsers
forFetchSameUsers user = ForFetchSameUsers (firstName user) (lastName user)
    where
        firstName = Domain.User.PreContractUser.firstName
        lastName  = Domain.User.PreContractUser.lastName
