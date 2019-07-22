object Solution {
    def numberOfArithmeticSlices(A: Array[Int]): Int = {
        var r = 0
        var i = 0
        while (i <= A.length - 3) {
            val d = A(i+1) - A(i)
            var j = i + 2
            while (j < A.length && A(j) - A(j-1) ==d) j += 1
            val k = j - i
            // 1 3  5 7 8
            // 0 1  2 3 4   - 4 
            // c(k, 2) - (k-1)
            r += k*(k-1)/2 - k + 1
            i = j - 1
        }
        r
    }
}