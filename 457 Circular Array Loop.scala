import scala.util.control.Breaks._
object Solution {
    def circularArrayLoop(nums: Array[Int]): Boolean = {
        val len = nums.length
        val visited = new Array[Int](len)
        for (i<-nums.indices) { breakable {
            val pos = nums(i) > 0
            var k = i
            while(true) {
                if (visited(k) == i + 1) return true
                if (visited(k) > 0) break
                val v = nums(k)
                if ((nums(k) > 0) != pos) break
                visited(k) = i+1
                val n = (v%len+k+len) %len
                if (n==k) break
                k = n
            }   
        }}
        false
    }
}