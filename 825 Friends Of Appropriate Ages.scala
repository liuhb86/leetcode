object Solution {
    def numFriendRequests(ages: Array[Int]): Int = {
        val b = new Array[Int](121)
        for (p<-ages) b(p) += 1
        var i = 15; 
        var s = 0
        var r = 0
        for (k<-15 to 120) {
            s += b(k)
            val ni = k / 2 + 8
            for (x<-i until ni) s-=b(x)
            i = ni
            r += b(k)* (s-1)
        }
        r
    }
}