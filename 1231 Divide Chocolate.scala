object Solution {
    def maximizeSweetness(sweetness: Array[Int], K: Int): Int = {
        var begin = sweetness.min
        var end = sweetness.sum / (K+1) + 1
        while (end - begin > 1) {
            val mid = (begin + end) / 2
            if (valid(sweetness, K, mid)) {
                begin = mid
            } else {
                end = mid
            }
        }
        begin
    }
    
    def valid(sweetness: Array[Int], K: Int, s: Int) : Boolean = {
        var k = K + 1
        var i = sweetness.length - 1
        while (k > 0 && i >= k - 1) {
            var t = 0
            while (t < s &&  i>=k-1) {
                t += sweetness(i)
                i-=1
            }
            if (t<s) return false
            k -= 1
        }
        k == 0
    }
}