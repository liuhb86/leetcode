object Solution {
    def poorPigs(buckets: Int, minutesToDie: Int, minutesToTest: Int): Int = {
        if (buckets <=1) return 0
        val base = minutesToTest/minutesToDie + 1
        if (base <= 1) return -1
        var nbuckets = 1
        var n = buckets -1
        while (n >= base) {
            nbuckets +=1
            n /= base
        }
        nbuckets
    }
}