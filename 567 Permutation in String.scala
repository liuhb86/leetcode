object Solution {
    def checkInclusion(s1: String, s2: String): Boolean = {
        if (s1.length > s2.length) return false
        val d1 = new Array[Int](26)
        val d2 = new Array[Int](26)
        for (c<-s1) d1(c-'a') += 1
        for (i<- 0 until s1.length -1) {
            val c = s2(i)
            d2(c-'a') += 1
        }
        var f = 0
        var k = 0
        for (i<-s1.length -1 until s2.length) {
            val c = s2(i)
            d2(c-'a') += 1
            if (d1(f) == d2(f)) {
                f = diff(d1, d2)
                if (f < 0) return true
            }
            d2(s2(k) -'a') -= 1
            k+=1
        }
        false
    }
    
    def diff(d1: Array[Int], d2: Array[Int]) : Int = {
        for (i<-0 until 26) {
            if (d1(i) != d2(i)) return i
        }
        return -1
    }
}