object Solution {
    def minimumAbsDifference(arr: Array[Int]): List[List[Int]] = {
        val s = arr.sorted
        var d = Int.MaxValue
        for (i<-1 until s.length) {
            d = d.min(s(i) - s(i-1))
        }
        val r = scala.collection.mutable.ListBuffer[List[Int]]()
        for (i<- 1 until s.length) {
            if (s(i)- s(i-1) == d) r += List(s(i-1), s(i))
        }
        r.result
    }
}