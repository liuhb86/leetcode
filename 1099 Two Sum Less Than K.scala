object Solution {
    def twoSumLessThanK(A: Array[Int], K: Int): Int = {
        val s = A.sorted
        var i = 0
        var j = A.length - 1
        var r = -1
        while (i<j) {
            while (j > i && s(i) + s(j) >= K) j-=1
            if (j>i) r = r.max(s(i)+s(j))
            i +=1
        }
        r
    }
}