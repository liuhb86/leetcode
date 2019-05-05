object Solution {
    def toGoatLatin(S: String): String = {
        val vowelWordPattern = "[aeiouAEIOU].*".r
        S.split(" ").zipWithIndex.map{ case(word, index) =>
            val goatLatin = word match {
                case vowelWordPattern() => word
                case _ => word.tail + word.head
            }
            goatLatin + "ma" + ("a" * (index + 1))
        }.mkString(" ")
    }
}