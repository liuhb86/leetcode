object Solution {
    def numEnclaves(A: Array[Array[Int]]): Int = {
        var count = 0
        for (i<- 0 until A.length) {
            for (j<- 0 until A(i).length) {
                if (A(i)(j) ==1) {
                    val (b, c) = flood(A, i,j)
                    if (b) count +=c
                }
            }
        }
        count
    }
    
    def flood(A: Array[Array[Int]], i: Int, j: Int) : (Boolean, Int) = {
        if (i<0 || i >= A.length) return (false, 0)
        if (j<0 || j >= A(i).length) return (false, 0)
        if (A(i)(j) == 0) return (true, 0)
        A(i)(j) = 0
        var b = true
        var c = 1
        var r = flood(A, i -1,j)
        b &&= r._1; c+= r._2
        r = flood(A, i+1,j)
        b &&= r._1; c+= r._2
        r = flood(A, i, j-1)
        b &&= r._1; c+= r._2
        r = flood(A, i, j+1)
        b &&= r._1; c+= r._2
        (b,c)
    }
}