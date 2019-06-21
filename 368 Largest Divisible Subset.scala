import scala.collection.mutable.ListBuffer
object Solution {
    def largestDivisibleSubset(nums: Array[Int]): List[Int] = {
        val sorted = nums.sorted
        val r = new Array[(Int, List[Int])](sorted.length)
        var m : (Int, List[Int]) = (0,Nil)
        for (i<-sorted.indices) {
            var ms: List[Int] = Nil 
            var ml = 0
            val v = sorted(i)
            for (j<-0 until i) {
                if (v % sorted(j) == 0 && r(j)._1>ml) {
                    ml = r(j)._1
                    ms = r(j)._2
                }
            }
            val vi = ((ml+1, v:: ms))
            r(i) = vi
            if (vi._1 > m._1) m = vi
        }
        m._2
    }
}