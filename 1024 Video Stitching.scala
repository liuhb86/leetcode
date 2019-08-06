object Solution {
    def videoStitching(clips: Array[Array[Int]], T: Int): Int = {
        val sorted = clips.sortBy(_(0))
        var t = 0
        var m = -1
        var r = 0
        for (Array(a,b)<-sorted) {
            if (a<=t) {
                if (b>m) {
                    m = b
                    if (m >= T) return r + 1
                }
            } else {
                println(t, m, r)
                if (m < a) return -1
                r += 1 
                t = m
                m = b
                if (m >= T) return r + 1
            }
        }
        -1
    }
}