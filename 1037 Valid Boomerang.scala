object Solution {
    def isBoomerang(points: Array[Array[Int]]): Boolean = {
        val dx1 = points(0)(0) - points(1)(0)
        val dy1 = points(0)(1) - points(1)(1)
        val dx2 = points(2)(0) - points(1)(0)
        val dy2 = points(2)(1) - points(1)(1)
        // dy1/dx1 = dy2/dx2
        dy1 * dx2 != dy2 * dx1
    }
}