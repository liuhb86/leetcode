object Solution {
    def champagneTower(poured: Int, query_row: Int, query_glass: Int): Double = {
        var current = Array(poured.toDouble)
        var prev : Array[Double] = null
        for (i<-0 to query_row) {
            val next = new Array[Double](current.length + 1)
            for (j<-0 to i) {
                if (current(j) > 1.0) {
                    val overflow = (current(j) - 1.0) / 2.0
                    next(j) += overflow
                    next(j+1) += overflow
                    current(j) = 1.0
                }
            }
            prev = current
            current = next
            //println(current.mkString(","))
        }
        prev(query_glass)
    }
}