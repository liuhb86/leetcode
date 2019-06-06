object Solution {
    def advantageCount(A: Array[Int], B: Array[Int]): Array[Int] = {
        val as = A.sorted
        val bs = B.zipWithIndex.sortBy(_._1)
        val r = new Array[Int](A.length)
        var bi = 0
        var bj = B.length - 1
        for (n<-as) {
            if (n > bs(bi)._1) {
                r(bs(bi)._2) = n
                bi += 1
            } else {
                r(bs(bj)._2) = n
                bj -= 1
            }
        }
        r
    }
}