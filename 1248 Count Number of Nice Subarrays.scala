import scala.collection.mutable.ArrayBuffer
object Solution {
    def numberOfSubarrays(nums: Array[Int], k: Int): Int = {
        val ab = ArrayBuffer[Int]()
        ab += 0
        var i = 0
        for (n<-nums) {
            if ((n & 1) == 0) {
                ab(i) += 1
            } else {
                ab += 0
                i += 1
            }
        }
        var r = 0
        var p = 0; var q = k
        while (q<ab.length) {
            r += (ab(p) + 1) * (ab(q) + 1)
            p += 1
            q += 1
        }
        r
    }
}