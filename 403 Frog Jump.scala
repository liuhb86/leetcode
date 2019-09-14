object Solution {
    def canCross(stones: Array[Int]): Boolean = {
        if (stones(1) != 1) return false
        val M = 2000
        val dp = Array.ofDim[Int](stones.length, stones.length)
        val map = stones.zipWithIndex.toMap
        for (i<-0 until stones.length) {dp(0)(i) = M; dp(1)(i) = M}
        dp(1)(1) = 1
        for (i<- 2 until stones.length) {
            val d = stones(i)
            for (j<-1 until stones.length) {
                var v = M
                val e = map.get(d-j)
                if (e.isDefined) {
                    val i0 = e.get
                    v = dp(i0)(j)
                    if (j>1) v = v.min(dp(i0)(j-1))
                    if (j<stones.length -1) v = v.min(dp(i0)(j+1))
                }
                dp(i)(j) = v + 1
                //println(i,j, dp(i)(j))
            }
        }
        for (i<-1 until stones.length) {
            if (dp(stones.length - 1)(i) < M) return true
        }
        false
    }
}