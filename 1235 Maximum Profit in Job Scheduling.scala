import java.util.TreeMap
object Solution {
    def jobScheduling(startTime: Array[Int], endTime: Array[Int], profit: Array[Int]): Int = {
        var r = 0
        val map = new TreeMap[Int, Int]()
        map.put(0,0)
        val s = startTime.zip(endTime).zip(profit).sortBy(_._1._2)
        for (((a,b),p) <- s) {
            val m = map.floorEntry(b).getValue.max(
                map.floorEntry(a).getValue + p)
            r = r.max(m)
            map.put(b, m)
        }
        r
    }
}