object Solution {
    def heightChecker(heights: Array[Int]): Int = {
        val sorted = heights.sorted
        heights.zip(sorted).count(x => x._1!= x._2 )
    }
}