object Solution {
    def orderOfLargestPlusSign(N: Int, mines: Array[Array[Int]]): Int = {
        val h = Array.ofDim[Int](N,N)
        val v = Array.ofDim[Int](N,N)
        val m = Array.fill(N)(Array.fill(N)(1))
        for (Array(x,y)<-mines) m(x)(y) = 0
        
        for (i<-0 until N) {
            var j = 0
            while (j < N) {
                while (j<N && m(i)(j)==0) j += 1
                var k = N.min(j + 1)
                while (k < N && m(i)(k)==1) k += 1
                val L = (k-j+1) / 2
                for (p<-1 to L) {
                    h(i)(j+p-1) = p
                    h(i)(k-p) = p
                }
                j = k + 1
            }
        }
        for (i<-0 until N) {
            var j = 0
            while (j < N) {
                while (j<N && m(j)(i)==0) j += 1
                var k = N.min(j + 1)
                while (k < N && m(k)(i)==1) k += 1
                val L = (k-j+1) / 2
                for (p<-1 to L) {
                    v(j+p-1)(i) = p
                    v(k-p)(i) = p
                }
                j = k + 1
            }
        }
        var r = 0
        for (i<-0 until N) {
            for (j<-0 until N) {
                r = r.max(h(i)(j).min(v(i)(j)))
            }
        }
        r
    }
}