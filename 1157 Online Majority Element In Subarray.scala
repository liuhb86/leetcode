import java.util.TreeMap
import scala.collection.mutable.Map
import scala.util.Random
class MajorityChecker(_arr: Array[Int]) {
    
    val map = Map[Int, TreeMap[Int, Int]]()
    
    for (i<-_arr.indices) {
        val v = _arr(i)
        val m = map.getOrElseUpdate(v, new TreeMap[Int, Int]())
        val c = m.size()
        m.put(i, c+1)
    }
    
    val M = 20
    
    def count(c: Int, left: Int, right: Int) : Int =  {
        val m = map(c)
        val lower = m.lowerEntry(left)
        val c1 = if (lower == null) 0 else lower.getValue
        val upper = m.floorEntry(right)
        val c2 = if (upper == null) 0 else upper.getValue
        c2 - c1
    }
    
    def query(left: Int, right: Int, threshold: Int): Int = {
        if (right - left < 2* M) {
            for (i<-1 to M) {
                val c = _arr(left + Random.nextInt(right-left+1))
                if (count(c, left, right) >= threshold) return c
            }
            -1
        } else {
            var c = 0
            var k = 0
            for (i<-left to right) {
                if (k==0) {c= _arr(i); k = 1}
                else if (_arr(i)==c) k+=1
                else k-=1
            }
            if(count(c, left, right)>=threshold) c else -1
        }
    }
}

/**
 * Your MajorityChecker object will be instantiated and called as such:
 * var obj = new MajorityChecker(arr)
 * var param_1 = obj.query(left,right,threshold)
 */