object Solution {
    def openLock(deadends: Array[String], target: String): Int = {
        val visited = scala.collection.mutable.Set(deadends.map(_.toInt):_*)
        if (visited(0)) return -1
        var t = target.toInt
        var list = List(0)
        var r = 0
        while (list != Nil) {
            var next : List[Int] = Nil
            for (n<-list) {
                if (n==t) return r
                var x = n
                var p = 1
                for (i<- 1 to 4) {
                    val d = x % 10
                    val nd = if (d==9) -p*9 else p
                    val nn = n + nd
                    if (!visited(nn)) {
                        next = nn :: next
                        visited += nn
                    }
                    val pd = if (d==0) p*9 else -p
                    val pn = n + pd
                    if (!visited(pn)) {
                        next = pn :: next
                        visited += pn
                    }
                    x = x / 10
                    p = p * 10
                }
            }
            r += 1
            list = next
        }
        -1
    }
}