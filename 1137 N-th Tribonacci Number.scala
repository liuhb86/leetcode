object Solution {
    def tribonacci(n: Int): Int = {
        val t = Array(0,1,1)
        if (n <3) return t(n)
        for (i <- 3 to n) {
            val x = t(0) + t(1) + t(2)
            t(0) = t(1); t(1) = t(2); t(2) = x
        }
        t(2)
    }
}