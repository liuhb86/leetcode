object Solution {
    def maxChunksToSorted(arr: Array[Int]): Int = {
        var k = 0
        var r = 0
        for (i<-arr.indices) {
            k = k.max(arr(i))
            if (k==i) r += 1
        }
        r
    }
}