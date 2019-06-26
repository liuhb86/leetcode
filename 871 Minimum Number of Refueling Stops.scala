object Solution {
    def minRefuelStops(target: Int, startFuel: Int, stations: Array[Array[Int]]): Int = {
        val pq = scala.collection.mutable.PriorityQueue[Int]()
        var stop = 0
        var fuel = startFuel
        var pos = 0
        for(Array(loc, f) <- stations) {
            while(pos + fuel < loc) {
                if (pq.isEmpty) return -1
                stop += 1
                fuel += pq.dequeue
            }
            fuel -= (loc-pos)
            pos = loc
            pq += f
            if (pos + fuel >= target) return stop
        }
        while(pos+fuel < target) {
            if (pq.isEmpty) return -1
            stop += 1
            fuel += pq.dequeue
        }
        stop
    }
}