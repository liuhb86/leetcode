object Solution {
    def findPoisonedDuration(timeSeries: Array[Int], duration: Int): Int = {
        var i = 0
        var r = 0
        var t = 0
        while (i < timeSeries.length) {
            r += (timeSeries(i) + duration -t).max(0).min(duration)
            t = t.max(timeSeries(i) + duration)
            i = search(timeSeries, i+1, t)
        }
        r
    }
    
    def search(a: Array[Int], i: Int, v: Int) : Int =  {
        var begin = i
        var end = a.length
        while (end - begin > 1) {
            val mid = (begin + end) / 2
            val n = a(mid)
            if (n == v) return mid
            if (n<v) {
                begin = mid
            } else {
                end = mid
            }
        }
        begin
    }
}