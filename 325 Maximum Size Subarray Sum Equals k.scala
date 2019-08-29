object Solution {
    def maxSubArrayLen(nums: Array[Int], k: Int): Int = {
        val map = scala.collection.mutable.Map[Int, Int]()
        map(0) = -1
        var r = 0
        var s = 0
        for (i<-nums.indices) {
            s += nums(i)
            val m = map.get(s-k)
            //println(i, s, m)
            if (m.isDefined) r = r.max(i-m.get)
            if (!map.contains(s)) map(s) = i
        }
        r
    }
}