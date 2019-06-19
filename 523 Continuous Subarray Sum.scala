object Solution {
    def checkSubarraySum(nums: Array[Int], k: Int): Boolean = {
        if (nums.length < 2) return false
        val set = scala.collection.mutable.Set[Int]()
        set += 0
        var s0 = mod(nums.head,k)
        for (n<-nums.tail) {
            val s1 = mod(s0 + n,k)
            if (set(s1)) return true
            set+= s0
            s0 = s1
        }
        false
    }
    
    def mod(n: Int, k: Int) : Int = {
        if (k >0) n% k
        else if (k<0) n %(-k)
        else n
    }
}