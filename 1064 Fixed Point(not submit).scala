object Solution {
    def fixedPoint(A: Array[Int]): Int = {
        var begin = 0
        var end = A.length
        while (end - begin > 1) {
            val mid = (begin + end -1) / 2
            val v = A(mid)
            if (v < mid) {
                begin = mid + 1
            } else if ( v > mid) {
                end = mid
            } else {
                end = mid + 1
            }
        }
        if (end > begin ) A(begin)
        else -1
    }
}