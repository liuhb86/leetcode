object Solution {
    def findMissingRanges(nums: Array[Int], lower: Int, upper: Int): List[String] = {
        val r = scala.collection.mutable.ListBuffer[String]()
        var i = lower.toLong
        for (_x<- nums ) {
            val x = _x.toLong
            if (x>i) {
                if (x==i+1) {
                    r += s"$i"
                } else {
                    r += s"$i->${x-1}"
                }
            }
            i = x + 1
        }
        val x = upper.toLong + 1
        if (x>i) {
            if (x==i+1) {
                r += s"$i"
            } else {
                r += s"$i->${x-1}"
            }
        }
        r.result
    }
}