import java.util.TreeMap
object Solution {
    def getSkyline(buildings: Array[Array[Int]]): List[List[Int]] = {
        var res : List[List[Int]] = Nil
        val map = new TreeMap[Int, Int]()
        val sorted = buildings.sortBy(x=> (x(0), -x(2)))
        for (Array(l, r, h) <- sorted) {
            while (!map.isEmpty && map.firstEntry.getKey < l) {
                val x = map.firstEntry.getKey
                map.remove(map.firstEntry.getKey)
                val y = if (map.isEmpty) 0 else map.firstEntry.getValue
                res = List(x, y) :: res
            }
            if (map.isEmpty || h > map.firstEntry.getValue) {
                res = List(l, h) :: res
            }
            val ceiling = map.ceilingEntry(r)
            if (ceiling != null && ceiling.getValue >=h) {
                // do not need to add right line
            } else {
                var floor = map.floorEntry(r)
                while (floor != null && floor.getValue <= h) {
                    map.remove(floor.getKey)
                    floor = map.floorEntry(r)
                }
                map.put(r, h)
            }
        }
        
        while (!map.isEmpty) {
            val x = map.firstEntry.getKey
            map.remove(map.firstEntry.getKey)
            val y = if (map.isEmpty) 0 else map.firstEntry.getValue
            res = List(x, y) :: res
        }
        res.reverse
    }
}