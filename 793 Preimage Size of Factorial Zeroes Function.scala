object Solution {
    def preimageSizeFZF(K: Int): Int = {
        val l = find(K.toLong)
        //println(l)
        if (l>=0) return 5 else 0
    }
    
    def find(K: Long) : Long = {
        var begin = K * 4 / 5
        var end = K * 5 + 6
        while(end > begin) {
            val mid = (begin + end -1) / 2
            val r = f(mid)
            if (r < K) {
                begin = mid + 1
            } else if (r > K) {
                end = mid
            } else {
                if (mid == begin) return begin
                end = mid + 1
            }
        }
        return -1
    }
    
    def f(_x: Long) : Long = {
        var t = 0L
        var x = _x
        while (x>=5) {
            x = x / 5
            t += x
        }
        //println(s"f(${_x})=$t")
        t
    }
}