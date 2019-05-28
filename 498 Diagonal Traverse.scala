object Solution {
    def findDiagonalOrder(matrix: Array[Array[Int]]): Array[Int] = {
        val it = new It(matrix)
        val r = new Array[Int](it.m * it.n)
        for (i<-0 until r.length) r(i) = it.next()
        r
    }
}

class It(matrix: Array[Array[Int]]) {
    val m = matrix.length
    val n = if (matrix.isEmpty) 0 else matrix.head.length
    var x: Int = 0 
    var y: Int = 0
    var up : Boolean = true
    def next() : Int = {
        val v = matrix(x)(y)
        if (up) {
            if (x > 0 && y < n - 1) {x-=1; y +=1;}
            else if (y < n -1) {y +=1; up=false;}
            else {x+=1; up=false}
        } else {
            if (y > 0 && x < m -1) {x+=1; y-=1;}
            else if (x < m -1) {x+=1;up=true;}
            else {y+=1; up=true;}
        }
        v
    }
}