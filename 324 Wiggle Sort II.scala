import scala.util.Random
object Solution {
    def wiggleSort(nums: Array[Int]): Unit = {
        val median = choosek(nums, 0, nums.length, nums.length / 2)    
        //println(nums.mkString(","))
        
        var i = 1
        var j = if (nums.length % 2 == 0) nums.length -2 else nums.length - 1
        while (i< j) {
            val t = nums(i); nums(i) = nums(j); nums(j) = t
            i += 2; j -= 2;
        }
        //println(nums.mkString(","))
        
        j = 1
        for (i<- j until nums.length by 2) {
            if (nums(i) != median) {nums(j) = nums(i); j+=2}
        }
        for (i<-j until nums.length by 2) nums(i) = median
        //println(nums.mkString(","))
        
        j = if (nums.length % 2 == 1) nums.length -1 else nums.length - 2
        for (i<- j to 0 by -2) {
            if (nums(i) != median) {nums(j) = nums(i); j-=2}
        }
        for (i<-j to 0 by -2) nums(i) = median
    }
    
    def choosek(nums: Array[Int], begin: Int, end: Int, k: Int) : Int = {
        val id = Random.nextInt(end-begin)
        val d = nums(begin + id)
        nums(begin + id) = nums(end - 1)
        var i = begin
        var j = end - 1
        while (i<j) {
            while (i < j && nums(i) < d) i += 1
            nums(j) = nums(i)
            while (i < j && nums(j) >=d ) j-= 1
            nums(i) = nums(j)
        }
        nums(i) = d
        while(j<end && nums(j) == d) j+=1
        if (begin + k < i) choosek(nums, begin, i, k)
        else if (begin + k >= j) choosek(nums, j, end, begin + k -j)
        else nums(i)
    }
}