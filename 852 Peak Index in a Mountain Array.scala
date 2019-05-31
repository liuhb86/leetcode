object Solution {
    def peakIndexInMountainArray(A: Array[Int]): Int = {
        var begin = 1
        var end = A.length -1
        while (true) {
            val mid = (begin + end)/2
            //println(s"$begin $end $mid")
            if (A(mid) > A(mid-1)) {
                if (A(mid) > A(mid+1)) return mid
                begin = mid + 1
            } else {
                end = mid
            }
        }
        throw new Exception()
    }
}