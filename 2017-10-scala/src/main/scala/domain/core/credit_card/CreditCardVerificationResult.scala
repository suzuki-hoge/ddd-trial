package domain.core.credit_card

sealed trait CreditCardVerificationResult

case object Valid extends CreditCardVerificationResult

case object Invalid extends CreditCardVerificationResult
