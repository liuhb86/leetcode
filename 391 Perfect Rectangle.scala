object Solution {
    def isRectangleCover(rectangles: Array[Array[Int]]): Boolean = {
        val left = rectangles.map(_(0)).min
        val right = rectangles.map(_(2)).max
        val top = rectangles.map(_(3)).max
        val bottom = rectangles.map(_(1)).min
        val area = (right-left)*(top-bottom)
        val sum = rectangles.map(x=> (x(2)-x(0)) *(x(3)-x(1))).sum
        if (sum != area) return false
        for (i<-rectangles.indices; j<- i+1 until rectangles.length) {
            if (overlap(rectangles(i), rectangles(j))) return false
        }
        true
    }
    
    def overlap(r1: Array[Int], r2: Array[Int]) : Boolean = {
        r1(0) < r2(2) && r1(2) > r2(0) && r1(1) < r2(3) && r1(3) > r2(1)
    }
}