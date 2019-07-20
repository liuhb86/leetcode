object Solution {
    def longestMountain(A: Array[Int]): Int = {
        if (A.length < 3) return 0
        var state = 0
        var last = A.head
        var length = 0
        var r = 0
        for (i<- 1 until A.length) {
            var d = A(i)
            if (d==last) {
                state = 0
            } else if (d > last) {
                if (state == 1) {
                    length += 1
                } else {
                    state = 1
                    length = 2
                }
            } else if (state != 0) {
                state = 2
                length += 1
                r = r.max(length)
            }
            last = d
        }
        r
    }
}