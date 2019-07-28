object Solution {
    def uncommonFromSentences(A: String, B: String): Array[String] = {
        val wa = A.split(" ")
        val ga = wa.groupBy(identity)
        val sa = ga.keySet
        val wb = B.split(" ")
        val gb = wb.groupBy(identity)
        val sb = gb.keySet
        ga.filter(x=> x._2.length == 1 && !sb(x._1)).toArray.map(_._1) ++
        gb.filter(x=> x._2.length == 1 && !sa(x._1)).toArray.map(_._1)
    }
}