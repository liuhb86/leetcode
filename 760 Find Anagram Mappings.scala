object Solution {
    def anagramMappings(A: Array[Int], B: Array[Int]): Array[Int] = {
        val g = B.zipWithIndex.groupBy(_._1).mapValues(_.toIterator)
        val r = new Array[Int](A.length)
        for (i<-A.indices) {
            r(i) = g(A(i)).next._2
        }
        r
    }
}