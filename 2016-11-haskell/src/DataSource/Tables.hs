module DataSource.Tables where

import Domain.User.ContractedUser

import Domain.User.UserId
import Domain.User.FirstName
import Domain.User.LastName
import Domain.User.Course
import Domain.User.Gender
import Domain.User.BirthDate

import Domain.Address.Address
import Domain.Address.PostalCode
import Domain.Address.Street

import Domain.Phone.PhoneNumber

import Domain.Mail.MailAddress

contractedUsers :: [ContractedUser]
contractedUsers = [ContractedUser (UserId "id-123") (FirstName "jane") (LastName "doe") Basic Male (BirthDate "19900101") (Address (PostalCode "111-2222") (Street "foo st")) (PhoneNumber "090-1111-2222") (MailAddress "love-the-boss@bigboss.net")]
