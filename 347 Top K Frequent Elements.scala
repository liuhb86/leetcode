object Solution {
    def topKFrequent(nums: Array[Int], k: Int): List[Int] = {
        val f = nums.groupBy(identity)
        val s = Array.fill[List[Int]](nums.length+1)(Nil)
        for ((n, v) <- f) {
            s(v.length) = n :: s(v.length)
        }
        var c = 0
        var r : List[Int] = Nil
        for(i<-nums.length to 1 by -1) {
            for (x<-s(i)) {
                r = x :: r
                c+=1
                if (c>=k) return r.reverse
            }
        }
        r.reverse
    }
}