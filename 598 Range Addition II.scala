object Solution {
    def maxCount(m: Int, n: Int, ops: Array[Array[Int]]): Int = {
        if (ops.isEmpty) return m * m
        val mm = ops.map(_(0)).min
        val mn = ops.map(_(1)).min
        mm * mn
    }
}