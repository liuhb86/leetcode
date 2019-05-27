class MyCalendar() {
    val map = new java.util.TreeMap[Int, Int]()
    def book(start: Int, end: Int): Boolean = {
        val before = map.floorEntry(start)
        if (before != null) {
            if (before.getValue() > start) return false 
        }
        val after = map.higherEntry(start)
        if (after != null) {
            if (after.getKey() < end) return false
        }
        map.put(start, end)
        true
    }

}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * var obj = new MyCalendar()
 * var param_1 = obj.book(start,end)
 */