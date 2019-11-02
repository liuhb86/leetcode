import scala.collection.mutable.{Set, ListBuffer}
object Solution {
    def minimumMoves(grid: Array[Array[Int]]): Int = {
        if (grid.length ==1 && grid.head.length ==2) return 0
        val R = grid.length
        val C = grid.head.length
        val TR = R -1
        val TC = C - 2
        var list = List((0,0,true))
        val set = Set((0,0,true))
        var d = 0
        while (list.nonEmpty) {
            d+=1
            val next = ListBuffer[(Int, Int, Boolean)]()
            for ((r,c, h)<-list) {
                //println(r,c,h)
                if (h) {
                    if (c < C - 2 && grid(r)(c+2) == 0) {
                       val p = (r, c+1, h)
                        if (!set(p)) {
                            if (p._1==TR && p._2==TC) return d
                            set +=p
                            next += p
                        }
                    }
                    if (r < R - 1
                        && grid(r+1)(c) == 0 && grid(r+1)(c+1) ==0) {
                        val p = (r+1, c, h)
                        if (!set(p)) {
                            if (p._1==TR && p._2==TC) return d
                            set+=p
                            next+=p
                        }
                        val pr = (r,c, !h)
                        if (!set(pr)) {
                            set+=pr
                            next+= pr
                        }
                    }
                } else {
                    if (r < R - 2 && grid(r+2)(c) == 0) {
                        val p = (r+1, c, h)
                        if (!set(p)) {
                            set+=p
                            next += p
                        }
                    }
                    if (c < C - 1
                        && grid(r)(c+1) == 0 && grid(r+1)(c+1) ==0) {
                        val p = (r, c+1,h)
                        if (!set(p)) {
                            set+=p
                            next+=p
                        }
                        
                        val pr = (r,c,!h)
                        if (!set(pr)) {
                            set+=pr
                            next+=pr
                        }
                    }                    
                }
            }
            list = next.result
        }
        -1
    }
}