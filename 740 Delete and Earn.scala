object Solution {
    def deleteAndEarn(nums: Array[Int]): Int = {
        val sorted = nums. groupBy(identity).mapValues(_.length).toArray.sortBy(_._1)
        var p = 0
        var r = 0
        var r2 = 0
        for ((n, c) <- sorted) {
            if (n!=p+1) {
                r2 = r
                r += n*c
            } else {
                val rn = r.max(n*c+r2)
                r2 = r
                r = rn
            }
            p = n
            //println(n, r, r2)
        }
        r
    }
}