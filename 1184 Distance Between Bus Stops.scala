object Solution {
    def distanceBetweenBusStops(distance: Array[Int], start: Int, destination: Int): Int = {
        if (start == destination) return 0
        var s = start; var t = destination
        if (s > t) { s = destination; t = start}
        var d = distance.sum
        var d1 = 0
        for (i<- s until t) d1 += distance(i)
        d1.min(d-d1)
    }
}