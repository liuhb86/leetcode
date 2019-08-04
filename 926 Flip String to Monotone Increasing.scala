object Solution {
    def minFlipsMonoIncr(S: String): Int = {
        val n0 = new Array[Int](S.length + 1)
        for (i<- S.length -1 to 0 by -1) {
            n0(i) = n0(i+1) + (if (S(i)=='0') 1 else 0)
        }
        var n1 = 0
        var r = S.length
        for (i<-S.indices) {
            r = r.min(n1+n0(i))
            if (S(i)=='1') n1+=1
        }
        r.min(n1)
    }
}