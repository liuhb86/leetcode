object Solution {
    def numTilePossibilities(tiles: String): Int = {
        val s = tiles.groupBy(identity).mapValues(_.length)
        var r = Array(1)
        for ((_,v)<-s) {
            val nr = new Array[Int](r.length+v)
            for (i<-0 to v) {
                for (j<-0 until r.length) {
                    nr(i+j) += r(j) * c(i+j, i)
                }
            }
            r = nr
            //println(v)
            //println(r.mkString(","))
        }
        r.sum -1
    }
    
    def c(n: Int, k: Int) : Int =  {
        var a = 1
        var m = n
        var f = 1
        for (i<-1 to k) {
            a *= m
            f *= i
            m -= 1
        }
        a / f
    }
}