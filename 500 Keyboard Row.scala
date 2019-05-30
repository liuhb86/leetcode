object Solution {
    val s1 = "qwertyuiop".toSet
    val s2 = "asdfghjkl".toSet
    val s3 = "zxcvbnm".toSet
    def findWords(words: Array[String]): Array[String] = {
        words.filter{ case w =>
            val s = w.toLowerCase.toSet
            s.subsetOf(s1) || s.subsetOf(s2) || s.subsetOf(s3)
        }
    }
}