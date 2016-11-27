module Domain.User.ContractedUserFixture where

import Domain.User.ContractedUser

import Domain.User.UserId
import Domain.User.FirstName
import Domain.User.LastName
import Domain.User.Course
import Domain.User.Gender
import Domain.User.BirthDate

import qualified Domain.Address.AddressFixture as AddressF

import Domain.Phone.PhoneNumber

import Domain.Mail.MailAddress

construct :: Course -> BirthDate -> ContractedUser
construct course birthDate = ContractedUser (UserId "id-123") (FirstName "john") (LastName "doe") course Male birthDate AddressF.get (PhoneNumber "090-1111-2222") (MailAddress "love-the-boss@bigboss.net")
