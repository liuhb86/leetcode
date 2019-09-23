object Solution {
    def findContestMatch(n: Int): String = {
        val s = (1 to n).toArray.map(_.toString)
        var k = n
        while (k > 1) {
            for (i<-0 until k/2) {
                s(i) = s"(${s(i)},${s(k-1-i)})"
            }
            k/=2
        }
        s(0)
    }
}