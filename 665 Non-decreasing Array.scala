import scala.util.control.Breaks._
object Solution {
    def checkPossibility(nums: Array[Int]): Boolean = {
        for (i <- 1 until nums.length) {
            if (nums(i) < nums(i-1)) {
                return dec (nums.take(i) ++ nums.drop(i+1)) || dec(nums.take(i-1) ++ nums.drop(i))
            }
        }
        true
    }
    
    def dec(nums: Array[Int]) : Boolean = {
        for (i<- 1 until nums.length) {
            if (nums(i) < nums(i-1)) return false
        }
        true
    }
}