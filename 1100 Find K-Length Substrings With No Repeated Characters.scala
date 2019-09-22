object Solution {
    def numKLenSubstrNoRepeats(S: String, K: Int): Int = {
        if (K>S.length) return 0
        val count = new Array[Int](26)
        var dup = 0
        var r = 0
        for (i<-0 until K-1) {
            val x = S(i) - 'a'
            count(x) += 1
            if (count(x) == 2) dup += 1
        }
        for (i<- K-1 until S.length) {
            val x = S(i) -'a'
            count(x) += 1
            if (count(x) == 2) dup +=1
            if (dup == 0) r+=1
            val y = S(i-K+1) - 'a'
            count(y) -= 1
            if (count(y) == 1) dup -=1
        }
        r
    }
}