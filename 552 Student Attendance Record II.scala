object Solution {
    val M = 1000000007L
    def checkRecord(n: Int): Int = {
        if (n==1) return 3
        var np1 = 1L
        var pp1 = 1L
        //var nt1 = 1
        //var pt1 = 0
        // pp, pl, lp, ll
        var np2 = 2L
        var pp2 = 3L
        var nt2 = 2L
        var pt2 = 1L
        for (i<-3 to n) {
            val np = (np2 + nt2) % M
            val pp = (pp2 + pt2 + np)%M
            val nt = (np2 + np1)%M
            val pt = (pp2 + pp1)%M
            np1 = np2; pp1=pp2
            np2 = np;pp2=pp;nt2=nt;pt2=pt
        }
        ((np2+pp2+nt2+pt2)%M).toInt
    }
}