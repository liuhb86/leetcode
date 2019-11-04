import scala.collection.mutable.Map
object Solution {
    def maxEqualFreq(nums: Array[Int]): Int = {
        val g = nums.groupBy(identity).mapValues(_.length)
        val numMap = Map[Int, Int]()
        val countMap = Map[Int, Int]()
        for ((n, c)<-g) {
            numMap(n) = c
            countMap(c) = countMap.getOrElse(c, 0) + 1
        }
        if (numMap.size == 1) return nums.length
        if (countMap.size == 1 && countMap.contains(1)) return nums.length
        for (i <-nums.length -1 to 0 by -1) {
            if (countMap.size == 2) {
                val c1 = countMap.get(1)
                if (c1 == Some(1)) return i+1
                val keys = countMap.keys
                val m = keys.max
                val min = keys.min
                if (m == min + 1 && countMap(m) ==1) {
                    return i+1
                }
            }
            val n = nums(i)
            var c = numMap(n)
            if (c==1) {
                numMap -= n
            } else {
                val c1 = c - 1
                numMap(n) = c1
                countMap(c1) = countMap.getOrElse(c1, 0) + 1
            }
            val cc = countMap(c)
            if (cc == 1) {
                countMap -= c
            } else {
                countMap(c) = cc - 1
            }
        }
        throw new Exception()
    }
}