object Solution {
    def carFleet(target: Int, position: Array[Int], speed: Array[Int]): Int = {
        if (position.isEmpty) return 0
        val cars = position.map(x => (target-x).toLong).zip(speed.map(_.toLong)).sortBy(_._1)
        var d0 = cars.head._1
        var s0 = cars.head._2
        var fleet = 1
        for ((d, s) <- cars) {
            // d1/s1 > d0/s0 => d1*s0 > d0*s1
            if (d*s0 > d0*s) {
                fleet += 1
                d0 = d
                s0 = s
            }
        }
        fleet
    }
}