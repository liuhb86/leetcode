class RangeModule() {
    val map = new java.util.TreeMap[Int, Int]()
    def addRange(left: Int, right: Int) {
        removeRange(left, right)
        var l = left
        var r = right
        if (map.containsKey(right)) {
            r = map.get(right)
            map.remove(right)
        }
        val q = map.lowerEntry(left)
        if (q != null && q.getValue == left) {
            l = q.getKey
        }
        map.put(l, r)
    }

    def queryRange(left: Int, right: Int): Boolean = {
        val p = map.floorEntry(left)
        p != null && p.getValue >= right
    }

    def removeRange(left: Int, right: Int) {
        val p = map.lowerEntry(left)
        if (p != null) {
            val to = p.getValue
            if (to > left) map.put(p.getKey, left)
            if (to > right) map.put(right, to)
        }
        while(true) {
            val p = map.ceilingEntry(left)
            if (p==null) return
            if (p.getValue <= right) {
                map.remove(p.getKey)
            } else {
                if (p.getKey < right) { 
                    map.remove(p.getKey)
                    map.put(right, p.getValue)
                }
                return
            }
        }
    }

}


/**
 * Your RangeModule object will be instantiated and called as such:
 * var obj = new RangeModule()
 * obj.addRange(left,right)
 * var param_2 = obj.queryRange(left,right)
 * obj.removeRange(left,right)
 */