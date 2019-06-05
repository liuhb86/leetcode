object Solution {
    def nextGreaterElements(nums: Array[Int]): Array[Int] = {
        if (nums.isEmpty) return Array[Int]()
        val mi = nums.zipWithIndex.maxBy(_._1)._2
        val b = scala.collection.mutable.ListBuffer[Int]()
        val r = new Array[Int](nums.length)
        for (ii<- 0 until nums.length) {
            val i = (mi + 1 + i) % nums.length
            val vi = nums(i)
            while (b.nonEmpty && vi > nums(b.last)) {
                r(b.last) = vi
                b.trimEnd(1)
            }
            b += i
        }
        for (i <- b) {
            r(i) = -1
        }
        r
    }
}