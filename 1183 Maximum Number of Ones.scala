//peek
//observation: we just need to repeat the same pattern
object Solution {
    def maximumNumberOfOnes(width: Int, height: Int, sideLength: Int, maxOnes: Int): Int = {
        val c = scala.collection.mutable.ArrayBuffer[Int]()
        val m = width / sideLength
        val rm = width % sideLength
        val n = height / sideLength
        val rn = height % sideLength
        for (i<-0 until sideLength) {
            val x = if (i<rm) m + 1 else m
            for (j<-0 until sideLength) {
                val y = if (j<rn) n+1 else n
                c += x *y
            }
        } 
        c.result.sortBy(-_).take(maxOnes).sum
    }
}