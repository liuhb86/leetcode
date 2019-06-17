object Solution {
    def minMutation(start: String, end: String, bank: Array[String]): Int = {
        val b = bank.map(str2int).toSet
        val s = str2int(start)
        val e = str2int(end)
        if (e==s) return 0
        val visited = scala.collection.mutable.Set[Int]()
        var current = List(s)
        var m = 0
        while(current.nonEmpty) {
            m += 1
            var next: List[Int] = Nil
            for (c<- current) {
                var mask = 3
                var inc = 1
                for (i<- 1 to 8) {
                    var g = c & (~mask)
                    for (j<-1 to 4) {
                        if (g!=c && b(g) && !visited(g)) {
                            if (g==e) return m
                            visited(g) = true
                            next = g :: next
                        }
                        g += inc
                    }
                    mask <<= 2
                    inc <<= 2
                }
            }
            current = next
        }
        -1
    }
    
    def str2int(s : String) : Int = {
        var r = 0
        for (c <- s) {
            val v = c match {
                case 'A' => 0
                case 'C' => 1
                case 'G' => 2
                case 'T' => 3
            }
            r = (r << 2) + v
        }
        r
    }
}