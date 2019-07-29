class Solution(_nums: Array[Int]) {

    def pick(target: Int): Int = {
        var c = 0
        var r = 0
        for (i<-_nums.indices) {
            if (_nums(i) == target) {
                c += 1
                if (scala.util.Random.nextInt(c) == 0) r = i
            }
        }
        r
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = new Solution(nums)
 * var param_1 = obj.pick(target)
 */