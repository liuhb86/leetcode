object Solution {
    def isGoodArray(nums: Array[Int]): Boolean = {
        var g = nums.head
        for (n<-nums) {
            g = gcd(g, n)
            if (g==1) return true
        }
        false
    }
    
    def gcd(_a: Int, _b: Int) : Int = {
        var a = _a; var b = _b
        var r = a % b
        while (r != 0) {
            a = b
            b = r
            r = a % b
        }
        b
    }
}