package domain.credit_card;

import domain.user.register.error.UserRegistrationError;
import domain.user.register.error.UserRegistrationInvalidMessage;
import domain.user.register.error.UserRegistrationInvalidReason;

public enum CreditCardInvalidReason {
    InvalidNumber, InvalidBirthDate;

    public UserRegistrationError toUserRegistrationError() {
        return new UserRegistrationError(
                UserRegistrationInvalidReason.InvalidCreditCard,
                new UserRegistrationInvalidMessage(
                        (this == InvalidNumber) ? "invalid card number." : "invalid birth date."
                )
        );
    }
}
