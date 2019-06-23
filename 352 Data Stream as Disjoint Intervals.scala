class SummaryRanges() {

    /** Initialize your data structure here. */
    val map = new java.util.TreeMap[Int, Int]()

    def addNum(v: Int) {
        val i1 = map.ceilingEntry(v)
        if (i1 != null && i1.getKey == v) return
        val i0 = map.lowerEntry(v)
        if (i0 != null && i0.getValue >=v) return
        var e = v
        if (i1 != null && i1.getKey == v + 1) {
            e = i1.getValue
            map.remove(i1.getKey)
        }
        if (i0!= null && i0.getValue == v - 1) {
            map.put(i0.getKey, e)
        } else {
            map.put(v, e)
        }
    }

    def getIntervals(): Array[Array[Int]] = {
        import scala.collection.JavaConverters._
        map.asScala.toArray.map(x=> Array(x._1,x._2))
    }

}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * var obj = new SummaryRanges()
 * obj.addNum(`val`)
 * var param_2 = obj.getIntervals()
 */