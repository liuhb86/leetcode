object Solution {
    def isToeplitzMatrix(matrix: Array[Array[Int]]): Boolean = {
        val M = matrix.length
        val N = matrix.head.length 
        for (i<- 0 until M) {
            var x = i
            var y = 0
            val v = matrix(x)(y)
            while (x<M && y<N) {
                if (matrix(x)(y) != v) return false
                x+=1; y+=1
            }
        }
        for (i<- 1 until N) {
            var x = 0
            var y = i
            val v = matrix(x)(y)
            while (x<M && y<N) {
                if (matrix(x)(y) != v) return false
                x+=1; y+=1
            }
        }
        true
    }
}