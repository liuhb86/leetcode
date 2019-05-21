import scala.math.max
object Solution {
    def rob(nums: Array[Int]): Int = {
        if (nums.isEmpty) return 0
        if (nums.length == 1) return nums.head
        var m0 = 0
        var m1 = 0
        for (n <- nums.dropRight(1)) {
            val r0 = max(m0, m1)
            val r1 = m0 + n
            m0 = r0
            m1 = r1
        }
        val t0 = max(m0, m1)
        m0 = 0
        m1 = 0
        for (n <- nums.tail) {
            val r0 = max(m0, m1)
            val r1 = m0 + n
            m0 = r0
            m1 = r1
        }
        val t1 = max(m0, m1)
        max(t0, t1)
    }
}