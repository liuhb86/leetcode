object Solution {
    def minDeletionSize(A: Array[String]): Int = {
        if (A.length <= 1) return 0
        val columns = A.head.length
        val rows = (1 until A.length)
        (0 until columns).filter{ c =>
            rows.exists(r => A(r)(c) < A(r -1)(c))
        }.length
    }
}