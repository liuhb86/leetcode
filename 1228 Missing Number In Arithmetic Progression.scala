object Solution {
    def missingNumber(arr: Array[Int]): Int = {
        val intv = (arr.last -arr.head) / arr.length
        var begin = 1
        var end = arr.length
        while(end - begin > 1) {
            val mid = (begin + end -1) /2
            val n = arr(mid)
            if (arr(mid) == arr.head + mid*intv) {
                begin = mid + 1
            } else {
                end = mid + 1
            }
        }
        arr.head + begin * intv
    }
}