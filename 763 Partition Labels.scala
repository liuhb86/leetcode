object Solution {
    def partitionLabels(S: String): List[Int] = {
        val last = new Array[Int](26)
        for (i<-S.indices) last(S(i)-'a') = i
        var i = 0
        var k = 0
        var r : List[Int] = Nil
        while (i<S.length) {
            var j = i
            while (k<=j) {
                j = j.max(last(S(k)-'a'))
                k+= 1
            }
            //println(k)
            r = (k-i) :: r
            i = k
        }
        r.reverse
    }
}