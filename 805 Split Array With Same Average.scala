object Solution {
    def splitArraySameAverage(A: Array[Int]): Boolean = {
        if (A.length < 2) return false
        val sorted = A.sorted
        val set = A.toSet
        val max = sorted.last
        val sum = A.sum
        val sizes = (1 to A.length/2).filter(k => sum * k % A.length == 0)
        for (s<-sizes) {
            if (solve(sorted, 0, s, sum*s/A.length, max, set)) return true   
        }
        false
    }
    
    def solve(A: Array[Int], i: Int, s: Int, sum: Int, max: Int, set: Set[Int]) : Boolean = {
        if (i>=A.length) return false
        if (s == 1) return sum>=A(i) && set(sum)
        if (A.length - i < s) return false
        if (sum < A(i)*s || sum > max*s) return false
        if (solve(A, i+1, s-1, sum-A(i), max, set)) return true
        solve(A, i+1, s, sum, max, set)
    }
}