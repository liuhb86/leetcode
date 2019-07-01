object Solution {
    def detectCapitalUse(word: String): Boolean = {
        if (word.forall(_.isUpper)) true
        else if (word.tail.forall(_.isLower)) true
        else false
    }
}