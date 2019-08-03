//  1    11     11    1    211    11
//  1    22      1   11    221   221

object Solution {
    val M = 1000000007L
    def numTilings(N: Int): Int = {
        var dpa0 = 1L
        var dpa1 = 1L
        var dpb1 = 0L
        for (i<-2 to N) {
            val dpa = (dpa1 + dpa0 + 2 * dpb1) % M
            val dpb = (dpa0 + dpb1) % M
            dpa0 = dpa1
            dpa1 = dpa
            dpb1 = dpb
            //println(i, dpa1, dpb1)
        }
        dpa1.toInt
    }
}