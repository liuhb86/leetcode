object Solution {
    def getHint(secret: String, guess: String): String = {
        val a = secret.zip(guess).count(p => p._1 == p._2)
        val b = secret.intersect(guess).length - a
        s"${a}A${b}B"
    }
}