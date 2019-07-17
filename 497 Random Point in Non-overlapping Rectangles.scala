import java.util.TreeMap
class Solution(_rects: Array[Array[Int]]) {
    val rect = _rects.map(x=>(x(0), x(1), x(2)-x(0)+1, x(3)-x(1)+1))
    val map = new TreeMap[Int, (Int,Int,Int,Int)]()
    var s = 0
    for (r <- rect) {
        map.put(s, r)
        s += r._3 * r._4
    }
    def pick(): Array[Int] = {
        val k = scala.util.Random.nextInt(s)
        val e = map.floorEntry(k)
        val v = k - e.getKey()
        val r = e.getValue()
        val x = v % r._3
        val y = v / r._3
        Array(r._1+x, r._2+y)
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = new Solution(rects)
 * var param_1 = obj.pick()
 */