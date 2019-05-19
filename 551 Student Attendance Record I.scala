object Solution {
    def checkRecord(s: String): Boolean = {
        if (s.indexOf("LLL") >= 0) return false
        val firstAbsent = s.indexOf("A")
        if (firstAbsent < 0) return true
        s.indexOf("A", firstAbsent + 1) < 0
    }
}