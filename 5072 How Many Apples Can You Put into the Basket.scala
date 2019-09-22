object Solution {
    def maxNumberOfApples(arr: Array[Int]): Int = {
        val s = arr.sorted
        var w = 5000
        for (i<-arr.indices) {
            if (s(i)>w) return i
            w -= s(i)
        }
        s.length
    }
}