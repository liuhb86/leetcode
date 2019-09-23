object Solution {
    def fixedPoint(A: Array[Int]): Int = {
        var begin = 0
        var end = A.length
        while (end - begin > 1) {
            val mid = (begin +end - 1) / 2
            if (A(mid) < mid) {
                begin = mid + 1
            } else if (A(mid) > mid) {
                end = mid
            } else {
                end = mid + 1
            }
        }
        if (A(begin) == begin) begin
        else -1
    }
}