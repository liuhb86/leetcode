object Solution {
    def spiralMatrixIII(R: Int, C: Int, r0: Int, c0: Int): Array[Array[Int]] = {
        val N = R* C
        val result = new scala.collection.mutable.ArrayBuffer[Array[Int]](N)
        result += Array(r0,c0)
        var dr = 0
        var dc = 1
        var r = r0
        var c = c0
        var k = 1
        while (result.length < N) {
            if (dr==0 && r>=0 && r<R) {
                val (c1,c2) = 
                    if (dc>0) ((c+1).max(0), (c+k).min(C-1))
                    else ((c-1).min(C-1), (c-k).max(0))
                for (i<- c1 to c2 by dc) {
                    result += Array(r,i)
                }
            } else if (dc==0 && c>=0 && c<C) {
                val (r1,r2) = 
                    if (dr>0) ((r+1).max(0), (r+k).min(R-1))
                    else ((r-1).min(R-1), (r-k).max(0))
                for (i<- r1 to r2 by dr) {
                    result += Array(i,c)
                }
            }
            r += k* dr; c+= k*dc
            //println(r,c)
            //println(result.head.mkString(" "))
            if (dc == 0) k += 1
            val t = dr; dr = dc; dc = -t;
        }
        result.toArray
    }
}