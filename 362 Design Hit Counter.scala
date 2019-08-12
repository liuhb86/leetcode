class HitCounter() {

    val M = 310
    /** Initialize your data structure here. */
    val hits = new Array[Int](M)
    var cur = 1
    var p = 1
    var r = 0
    var q = 0

    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    def hit(timestamp: Int) {
        trim(timestamp)
        r+=1       
        hits(p) += 1     
    }

    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    def getHits(timestamp: Int): Int = {
        trim(timestamp)
        r
    }
    
    def trim(t: Int) {
        if (t-cur >= 300) {
            r = 0
            p = 1
            q = 0
            hits(p) = 0
            hits(q) = 0
            cur = t
            return
        }
        while (cur - (p-q+M) % M <= t - 300) {
            //println(t, cur, p, q, hits(q), r)
            r -= hits(q)
            q = (q+1) % M
        }
        for (i<-1 to t - cur) {
            p = (p+1) % M
            hits(p) = 0
        }
        cur = t
    }

}

/**
 * Your HitCounter object will be instantiated and called as such:
 * var obj = new HitCounter()
 * obj.hit(timestamp)
 * var param_2 = obj.getHits(timestamp)
 */