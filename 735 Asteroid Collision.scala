object Solution {
    def asteroidCollision(asteroids: Array[Int]): Array[Int] = {
        val r = scala.collection.mutable.ArrayBuffer[Int]()
        for (a <- asteroids) {
            if (a > 0) {
                r+=a
            } else if (a<0) {
                if (r.isEmpty || r.last < 0) {
                    r += a
                } else {
                    var w = a
                    while(w<0 && r.nonEmpty && r.last >0) {
                        val l = r.last
                        if (w+l <= 0) {
                            r.trimEnd(1)
                        } 
                        if (w + l >=0) {
                            w = 0
                        }
                    }
                    if (w < 0) {
                        r += w
                    }
                }
            }
        }
        r.toArray
    }
}