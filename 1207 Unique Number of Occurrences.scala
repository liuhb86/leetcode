object Solution {
    def uniqueOccurrences(arr: Array[Int]): Boolean = {
        val g = arr.groupBy(identity).values.map(_.length).toArray
        g.length == g.distinct.length
    }
}