object Solution {
    def longestWPI(hours: Array[Int]): Int = {
        var r = 0
        var s = 0
        var p = 0
        for (i<- hours.indices) {
            if (hours(i) >8) s-=1 else s+=1
            if (s<0) r = i+1
            else {
                if (s>p) {
                    hours(p) = i
                    p += 1
                } else if (s<p) {
                    r = r.max(i-hours(s))
                }
            }
        }
        r
    }
}