object Solution {
    def findLongestChain(pairs: Array[Array[Int]]): Int = {
        val sorted = pairs.sortBy(_(0))
        var r = 1
        var b = sorted.head(1)
        for (Array(c,d)<-sorted) {
            if (d < b) {
                b = d
            } else if (c > b) {
                r += 1
                b = d
            }
        }
        r
    }
}