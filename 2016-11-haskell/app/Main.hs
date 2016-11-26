module Main where

import Domain.User.User
import Domain.User.PreContractUser
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

import Domain.Mail.MailAddress

import Domain.Phone.PhoneNumber

import Domain.CreditCard.CreditCard
import Domain.CreditCard.ExaminedCreditCard
import Domain.CreditCard.UnexaminedCreditCard
import Domain.CreditCard.ExamineResult
import Domain.CreditCard.Number
import Domain.CreditCard.Expiration
import Domain.CreditCard.SecurityCode

main :: IO ()
main = do
    let user1 = PreContractUser (FirstName "john") (LastName "doe") Basic Male   (BirthDate "19900101") (Address (PostalCode "111-2222") (Street "foo st")) (PhoneNumber "090-1111-2222") (MailAddress "love-the-boss@bigboss.net")
    let user2 = PreContractUser (FirstName "jane") (LastName "doe") Basic Female (BirthDate "20100101") (Address (PostalCode "111-2222") (Street "foo st")) (PhoneNumber "090-1111-2222") (MailAddress "love-the-boss@bigboss.net")

    print user1

    let users = ContractedUser (UserId "id-123") (FirstName "john") (LastName "doe") Basic Male   (BirthDate "19900101") (Address (PostalCode "111-2222") (Street "foo st")) (PhoneNumber "090-1111-2222") (MailAddress "love-the-boss@bigboss.net")

    print users
    print $ forFetchSameUsers user1

    let validCard = ValidCreditCard (Number "1111-2222-3333-4444") (Expiration "10/16") (SecurityCode "123")
    let invalidCard = InvalidCreditCard (Number "1111-2222-3333-4444") (Expiration "10/16") (SecurityCode "123")

    print $ isContractable user1 [] validCard
    print $ isContractable user2 [] validCard
    print $ isContractable user1 [] invalidCard
    print $ isContractable user1 [users] validCard

    let unexamined = UnexaminedCreditCard (Number "1111-2222-3333-4444") (Expiration "10/16") (SecurityCode "123")
    print unexamined
    print $ toExamined unexamined (ExamineResult True)
