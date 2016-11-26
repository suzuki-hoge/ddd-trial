module Domain.User.ContractedUser where

import Domain.User.UserId
import Domain.User.FirstName
import Domain.User.LastName
import Domain.User.Course
import Domain.User.Gender
import Domain.User.BirthDate

import Domain.Address.Address

import Domain.Phone.PhoneNumber

import Domain.Mail.MailAddress

data ContractedUser = ContractedUser { userId      :: UserId
                                     , firstName   :: FirstName
                                     , lastName    :: LastName
                                     , course      :: Course
                                     , gender      :: Gender
                                     , birthDate   :: BirthDate
                                     , address     :: Address
                                     , phoneNumber :: PhoneNumber
                                     , mailAddress :: MailAddress
                                     } deriving Show
