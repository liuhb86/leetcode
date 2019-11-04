
object Solution {
    def checkStraightLine(coordinates: Array[Array[Int]]): Boolean = {
        val Array(x0,y0) = coordinates.head
        val dx = coordinates(1)(0) - x0
        val dy = coordinates(1)(1) - y0
        // (y - y0) / (x - x0) = dy/dx
        // dx(y-y0) = dy(x-x0)
        for (i<- 3 until coordinates.length) {
            val Array(x, y) = coordinates(i)
            if (dx*(y-y0) != dy*(x-x0)) return false
        }
        true
    }
}