object Solution {
    def reversePairs(nums: Array[Int]): Int = {
        merge(nums.map(_.toLong), 0, nums.length)
    }
    
    def merge(nums: Array[Long], begin: Int, end: Int) : Int = {
        if (end - begin <= 1) return 0
        val mid = (begin + end) / 2
        val rleft = merge(nums, begin, mid)
        val rright = merge(nums, mid, end)
        var i = begin
        var j = mid
        var rbetween = 0
        while (i<mid && j < end) {
            if (nums(i) > 2 *nums(j)) {
                rbetween += mid - i
                j += 1
            } else {
                i += 1
            }
        }
        mergeSort(nums, begin, end, mid)
        rleft + rright + rbetween
    }
    
    def mergeSort(nums: Array[Long], begin: Int, end: Int, mid: Int) = {
        val t = new Array[Long](end-begin)
        var k = 0
        var i = begin
        var j = mid
        while(i<mid && j<end) {
            if (nums(i) <= nums(j)) {
                t(k) = nums(i)
                i += 1
                k +=1
            } else {
                t(k) = nums(j)
                j += 1
                k +=1
            }
        }
        while (i<mid) {
            t(k) = nums(i)
            i += 1
            k +=1
        }
        while (j<end) {
            t(k) = nums(j)
            j += 1
            k +=1
        }
        for (z<-0 until t.length) {
            nums(begin+z) = t(z)
        }
    }
}