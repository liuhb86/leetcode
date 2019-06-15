object Solution {
    def numUniqueEmails(emails: Array[String]): Int = {
        emails.map(normalize).toSet.size
    }
    
    def normalize(email: String) : String = {
        val iat = email.indexOf('@')
        var localName = email.take(iat)
        val iplus = localName.indexOf('+')
        if (iplus >= 0) localName = localName.take(iplus)
        localName.filter(_!='.') ++ email.drop(iat)
    }
}