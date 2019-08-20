import scala.collection.mutable.{PriorityQueue, StringBuilder}
object Solution {
    def addBoldTag(s: String, dict: Array[String]): String = {
        val pq = new Pq(s, dict)
        val r = new StringBuilder()
        var p = 0
        while (!pq.isEmpty) {
            val q = pq.dequeue
            val i = q._1
            var j = q._2
            r ++= s.substring(p, i)
            r ++= "<b>"
            while (!pq.isEmpty && pq.head._1 <= j) {
                val x = pq.dequeue
                j = j.max(x._2)
            }
            r ++= s.substring(i, j)
            r ++= "</b>"
            p = j
        }
        r ++= s.substring(p, s.length)
        r.toString
    }
}

class Pq(s: String, dict: Array[String]) {
    val pq = PriorityQueue[(Int, String)]()(Ordering.by(-_._1))
    
    for (w<-dict) {
        val i = s.indexOf(w)
        if (i >= 0) pq += ((i, w))
    }
    
    def isEmpty() : Boolean = pq.isEmpty
    
    def head : (Int, Int) = {
        val (i,w) = pq.head
        (i, i + w.length)
    }
    
    def dequeue() : (Int, Int) = {
        val (i, w) = pq.dequeue
        val j = s.indexOf(w, i+1)
        if (j >=0) pq += ((j,w))
        (i, i + w.length)
    }
}

