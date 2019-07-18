import scala.collection.mutable.ArrayBuffer
object Solution {
    def lengthOfLIS(nums: Array[Int]): Int = {
        val b = ArrayBuffer[Int]()
        for (n<- nums) {
            val p = bsearch(b, n)
            //println("p", p)
            if (p>=b.length) b += n
            else b(p) = n
            //println(b.mkString(" "))
        }
        b.length
    }
    
    def bsearch(b: ArrayBuffer[Int], v: Int) : Int = {
        var begin = 0
        var end = b.length
        while (end - begin > 1) {
            val mid = begin + (end - begin - 1)/ 2
            val d = b(mid)
            if (d == v) return mid
            if (d>v) end = mid + 1
            else begin = mid + 1
        }
        if (end - begin == 1) {
            return if (b(begin) >= v) begin else end
        }
        begin
    }
}