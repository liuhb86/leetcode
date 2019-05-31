object Solution {
    def binaryGap(N: Int): Int = {
        var mg = 0
        var last1 = -1
        var last = 2
        var n = N
        var p = 0
        while (n > 0) {
            val b = n & 1
            if (b == 1) {
                if (last == 0 && last1 >= 0) {
                    val g = p - last1
                    if (g > mg) mg = g
                } else if (mg ==0 && last == 1) {
                   mg = 1 
                }
                last1 = p
            }
            last = b
            p += 1
            n = n >> 1
        }
        mg
    }
}