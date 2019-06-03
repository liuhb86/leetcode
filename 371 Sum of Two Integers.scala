object Solution {
    def getSum(a: Int, b: Int): Int = {
        var r = a
        var c = b
        while (c != 0) {
            val r1 = r ^ c
            val c1 = r & c
            r = r1
            c = c1 << 1
        }
        r
    }
}