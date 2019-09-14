import java.util.TreeMap
import scala.collection.JavaConverters._
object Solution {
    def medianSlidingWindow(nums: Array[Int], k: Int): Array[Double] = {
        if (k == 1) return nums.map(_.toDouble)
        val m = new M()
        for (i <- 0 until k - 1) {
            m.add(nums(i))
            //m.dprint
        }
        val r = new Array[Double](nums.length - k + 1)
        
        for (i<- k - 1 until nums.length) {
            val j = i + 1 - k
            m.add(nums(i))
            //m.dprint
            r(j) = m.getMedian
            m.remove(nums(j))
            //m.dprint
        }
        r
    }
}

class Q {
    val map = new TreeMap[Int, Int]()
    def remove(v: Int) {
        val c = map.get(v)
        if (c==1) map.remove(v)
        else map.put(v,c-1)
    }
    
    def add(v: Int) {
        map.put(v, map.getOrDefault(v, 0) + 1)
    }
    
    def first = map.firstKey
    def last = map.lastKey
    def isEmpty = map.isEmpty
    def dprint() {
        for ((v, c) <-map.asScala) {
            for (i<- 1 to c) print(s"$v ")
        }
    }
}

class M {
    val ql = new Q()
    val qu = new Q()
    var median : Option[Int] = None
    
    def getMedian() : Double = {
        if (median.isDefined) median.get.toDouble
        else (ql.last.toDouble + qu.first.toDouble) / 2.0
    }
    
    def add(v: Int) {
        if (median.isEmpty) {
            if (ql.isEmpty) {
                median = Some(v)
            } else {
                if (v < ql.last) {
                    median = Some(ql.last)
                    ql.remove(median.get)
                    ql.add(v)
                } else if (v>qu.first) {
                    median = Some(qu.first)
                    qu.remove(median.get)
                    qu.add(v)
                } else {
                    median = Some(v)
                }
            }
        } else {
            if (v<median.get) {
                ql.add(v)
                qu.add(median.get)
                median = None
            } else {
                qu.add(v)
                ql.add(median.get)
                median = None
            }
        }
    }
    
    def remove(v: Int) {
        if (median.isEmpty) {
            if (v <= ql.last) {
                ql.remove(v)
                median = Some(qu.first)
                qu.remove(median.get)
            } else {
                qu.remove(v)
                median = Some(ql.last)
                ql.remove(median.get)
            }
        } else {
            if (v == median.get) {
                median = None
            } else if (v < median.get) {
                ql.remove(v)
                ql.add(median.get)
                median = None
            } else {
                qu.remove(v)
                qu.add(median.get)
                median = None
            }
        }
    }
    
    def dprint() {
        ql.dprint()
        if (median.isDefined) print("*" + median.get + "* ")
        else print("* ")
        qu.dprint()
        println
    }
}