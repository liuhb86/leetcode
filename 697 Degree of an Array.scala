object Solution {
    def findShortestSubArray(nums: Array[Int]): Int = {
        val t = nums.zipWithIndex.groupBy(_._1)
        val degree = t.map(_._2.length).max
        t.filter(_._2.length==degree).map(x=> x._2.last._2 - x._2.head._2 + 1).min
    }
}