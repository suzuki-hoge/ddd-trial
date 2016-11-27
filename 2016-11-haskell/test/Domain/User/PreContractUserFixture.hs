module Domain.User.PreContractUserFixture where

import Domain.User.PreContractUser

import Domain.User.FirstName
import Domain.User.LastName
import Domain.User.Course
import Domain.User.Gender
import Domain.User.BirthDate

import qualified Domain.Address.AddressFixture as AddressF

import Domain.Phone.PhoneNumber

import Domain.Mail.MailAddress

construct :: Course -> BirthDate -> PreContractUser
construct course birthDate = PreContractUser (FirstName "john") (LastName "doe") course Male birthDate AddressF.get (PhoneNumber "090-1111-2222") (MailAddress "love-the-boss@bigboss.net")
