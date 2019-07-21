import java.util.TreeMap
class MyCalendarTwo() {
    val m1 = new TreeMap[Int, Int]()
    val m2 = new TreeMap[Int, Int]()
    
    def book(start: Int, end: Int): Boolean = {
        var ns = start
        var ne = end
        var e = m1.lowerEntry(end)
        var double: List[(Int, Int)] = Nil
        var toRemove : List[Int] = Nil
        while (e!= null && e.getValue() >start) {
            val os = start.max(e.getKey())
            val oe = end.min(e.getValue())
            if (triple(start, end)) return false
            double = (os, oe) :: double
            toRemove = e.getKey() :: toRemove
            ns = ns.min(e.getKey())
            ne = ne.max(e.getValue())
            e = m1.lowerEntry(e.getKey())
        }
        for ((s,e) <- double) m2.put(s,e)
        for (r <- toRemove) m1.remove(r)
        m1.put(ns, ne)
        true
    }
    
    def triple(start: Int, end: Int)  : Boolean = {
        val p = m2.lowerEntry(end)
        if (p==null) return false
        if (p.getValue() <= start) return false
        return true
    }

}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * var obj = new MyCalendarTwo()
 * var param_1 = obj.book(start,end)
 */