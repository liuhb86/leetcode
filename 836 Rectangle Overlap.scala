object Solution {
    def isRectangleOverlap(rec1: Array[Int], rec2: Array[Int]): Boolean = {
        rec1(0) < rec2(2) &&
        rec1(2) > rec2(0) &&
        rec1(1) < rec2(3) &&
        rec1(3) > rec2(1)
    }
}