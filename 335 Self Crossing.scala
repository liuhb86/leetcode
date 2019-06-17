object Solution {
    def isSelfCrossing(m: Array[Int]): Boolean = {
        val lastp = Array.fill(5)(Array(0,0))
        var lastb = new Array[Int](4)
        var outward = true
        var x = 0; var y= 0; var dx = 0; var dy = 1
        for (d<-m) {
            x += dx * d
            y += dy * d
            //println(s"$x $y $dx $dy")
            //if (outward) println(lastp.map(_.mkString(",")).mkString(" ")) else println(lastb.mkString(" "))
            val z = if (dx==0) y else x
            val inc = dx > 0 || dy > 0
            if (outward) {
                val zi = if (dx==0) 1 else 0
                val z0 = lastp(0)(zi)
                val z1 = lastp(1)(zi)
                var bound0 = false
                if (inc) {
                    if (z<=z1) {
                        outward = false
                        bound0 = (z>=z0)
                    }
                } else {
                    if (z>=z1) {
                        outward = false
                        bound0 = (z<=z0)
                    }
                }
                val np = Array(x,y)
                if (outward) {
                    for (i<-0 to 3) lastp(i) = lastp(i+1)
                    lastp(4) = np
                } else {
                    lastb(0) = lastp(if (bound0) 0 else 3)(1-zi)
                    lastb(1) = lastp(4)(zi)
                    lastb(2) = np(1-zi)
                    lastb(3) = np(zi)
                }
            } else {
                if (inc) {
                    if (z>= lastb(0)) return true
                } else {
                    if (z<= lastb(0)) return true
                }
                for (i<-0 to 2) lastb(i) = lastb(i+1)
                lastb(3) = z
            }
            
            val t = dx; dx= -dy; dy = t
        }
        false
    }
}