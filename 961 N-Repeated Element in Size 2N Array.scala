object Solution {
    def repeatedNTimes(A: Array[Int]): Int = {
        val s = A.sorted
        val m = A.length/2
        if (s(m) == s(m + 1)) s(m)
        else s(m - 1)
    }
}