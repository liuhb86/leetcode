object Solution {
    def numMovesStonesII(stones: Array[Int]): Array[Int] = {
        val s = stones.sorted
        val r = Array(minNum(s), maxNum(s))
        r
    }
    
    def minNum(stones: Array[Int]) : Int =  {
        val n = stones.length
        println(n)
        if (stones(n-1)- stones(0) + 1 == n) return 0
        if (stones(n-1)- stones(0) + 1 == n + 1) return 1
        if (stones(n-2) - stones(0) + 1 == n -1) return 2
        if (stones(n-1) - stones(1) + 1 == n -1) return 2
        var r = 0
        var j = 0
        for (i<-stones.indices) {
            while (j<n && stones(j) - stones(i) + 1 <= n) j += 1
            r = r.max(j-i)
        }
        n - r
    }
    
    def maxNum(stones: Array[Int]) : Int = {
        (stones.last - stones(1) + 1- stones.length + 1).max(
            stones(stones.length -2) - stones.head + 1 - stones.length + 1)
    }
}