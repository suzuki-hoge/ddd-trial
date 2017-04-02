package domain.user.register

import domain.user._

case class AppliedUser(
                        userName: UserName,
                        address: Address,
                        age: Age,
                        eMail: EMail,
                        registrationDate: RegistrationDate,
                        course: Course
                        )
