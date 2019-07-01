object Solution {
    def imageSmoother(M: Array[Array[Int]]): Array[Array[Int]] = {
        val r = Array.ofDim[Int](M.length, M.head.length)
        val c = Array.ofDim[Int](M.length, M.head.length)
        for (i<-M.indices; j<-M.head.indices) {
            for (di <- -1 to 1; dj <- -1 to 1) {
                val (ni, nj) = (i+di, j+dj)
                if (ni>=0 && ni<M.length && nj>=0 && nj < M.head.length)  {
                    r(i)(j) += M(ni)(nj)
                    c(i)(j) += 1
                }
            }
        }
        for (i<-M.indices; j<-M.head.indices) r(i)(j)/=c(i)(j)
        r
    }
}