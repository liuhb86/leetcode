object Solution {
    def removeVowels(S: String): String = {
        val v = Set('a', 'e', 'i', 'o', 'u')
        S.filter(!v(_))
    }
}