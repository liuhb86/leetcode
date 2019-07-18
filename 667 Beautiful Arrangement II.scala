//1 6 2 5 3 4
//1 5 2 4 3

object Solution {
    def constructArray(n: Int, k: Int): Array[Int] = {
        val r = new Array[Int](n)
        var p = 1
        var d = k
        var t = 1
        for (i<-0 to k) {
            r(i) = t
            t += d * p
            d -= 1
            p = -p
        }
        for (i<-k+1 until n) {
            r(i) = i+1 
        }
        r
    }
}