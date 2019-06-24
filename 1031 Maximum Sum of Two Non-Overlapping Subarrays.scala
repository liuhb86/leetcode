object Solution {
    def maxSumTwoNoOverlap(A: Array[Int], L: Int, M: Int): Int = {
        var r = 0
        for (z <-1 to 2) {
            val B = if (z==1) ((i:Int)=>A(i)) else ((i: Int)=> A(A.length - i -1))
            var sl = 0
            for (i<-0 until L) sl+=B(i)
            var msl = sl
            var sm = 0 
            for (i<-L until L+M) sm+=B(i)
            r = r.max(msl+sm)
            for (i<-L+M until A.length) {
                sm = sm - B(i-M) + B(i)
                sl = sl - B(i-M-L) + B(i-M)
                msl = msl.max(sl)
                r = r.max(sm+msl)
            }
        }
        r
    }
}