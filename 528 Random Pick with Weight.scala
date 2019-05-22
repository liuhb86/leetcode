import scala.collection.Searching._
class Solution(_w: Array[Int]) {
    
    val acc = new Array[Int](_w.length)
    acc(0) = _w(0)
    for (i<-1 until _w.length) {
        acc(i) = acc(i -1) + _w(i)
    }
    
    /*
    println(acc.mkString(","))
    
    val t = new Array[Int](_w.length)
    for (i<-0 until 10000) {
        val n = _pickIndex()
        t(n) += 1
    }
    println(t.map(_/10000.0 * acc.last).mkString(","))
    
    def pickIndex(): Int = {
      0
    }
    */
    
    def pickIndex(): Int = {
       
        val r = scala.util.Random.nextInt(acc.last) + 1
        //println(r)
        //println(acc.search(r).insertionPoint)
        acc.search(r).insertionPoint
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = new Solution(w)
 * var param_1 = obj.pickIndex()
 */