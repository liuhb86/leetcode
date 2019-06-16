object Solution {
    def longestOnes(A: Array[Int], K: Int): Int = {
        if (K == 0) return findMaxConsecutiveOnes(A)
        var usedz = 0
        var nextz = 0
        var start = 0
        while (nextz < A.length && A(nextz) == 1) nextz += 1
        var m = nextz
        while (nextz < A.length) {
            if (usedz == K) {
                while(A(start)==1) start+=1
                start+=1
            } else {
                usedz +=1
            }
            nextz += 1
            while (nextz < A.length && A(nextz) == 1) nextz += 1
            m = m.max(nextz - start)
        }
        m
    }
    
      def findMaxConsecutiveOnes(nums: Array[Int]): Int = {
        var m = 0
        var last = 0
        var c = 0
        for (n<-nums) {
            if (n == 0) {
                m = m.max(c)
                c = 0
            } else {
                c += 1
            }
            last = n
        }
        m.max(c)
    }
}