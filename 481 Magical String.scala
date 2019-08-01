object Solution {
    def magicalString(n: Int): Int = {
        if (n==0) return 0
        if (n<=3) return 1
        var r = 1
        val q = scala.collection.mutable.Queue[Int](2)
        var x = 1
        var c = 3
        while (c < n) {
            var h = q.dequeue
            if (h==1) {
                q += x
                r += 2-x
                c += 1
            } else {
                q += x
                r += 2-x
                c += 1
                if (c==n) return r
                q += x
                r += 2-x
                c += 1
            }
            x = 3 - x
        }
        r
    }
}