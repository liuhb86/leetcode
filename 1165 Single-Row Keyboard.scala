object Solution {
    def calculateTime(keyboard: String, word: String): Int = {
        val map = keyboard.zipWithIndex.toMap
        var last = 0
        var r = 0
        for (c<- word) {
            val t = map(c)
            r += scala.math.abs(t-last)
            last = t
        }
        r
    }
}