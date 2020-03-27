module Domain.User.ContractRejectReason where

data ContractRejectReason = NonAdult | AlreadyContracted | InvalidCreditCard deriving (Show, Eq)
