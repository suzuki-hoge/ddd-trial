package entry_application.domain

trait EntryCheckError

object Minority extends EntryCheckError

object InvalidCreditCard extends EntryCheckError

object SameUserExists extends EntryCheckError
