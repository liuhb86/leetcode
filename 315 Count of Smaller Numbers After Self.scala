object Solution {
    def countSmaller(nums: Array[Int]): List[Int] = {
        if (nums.isEmpty) return Nil
        val r = new Array[Int](nums.length)
        merge(nums, r, 0, nums.length)
        r.toList
    }
    
    def merge(nums: Array[Int], result: Array[Int], begin: Int, end: Int) : Array[Int] = {
        if (end-begin == 1) return Array(0)
        val mid= (begin + end) / 2
        val left = merge(nums, result, begin, mid)
        val right = merge(nums, result, mid, end)
        var i = 0
        var j = 0
        var k = 0
        val m = new Array[Int](end-begin)
        var c = 0
        while (k<m.length) {
            val chooseR = 
                if (i==left.length) true
                else if (j == right.length) false
                else nums(mid + right(j)) < nums(begin+left(i))
            if (chooseR) {
                c+=1
                m(k) = left.length + right(j)
                j += 1
            } else {
                result(begin+left(i)) += c
                m(k) = left(i)
                i += 1
            }
            k += 1
        }
        //println(s"$begin $end")
        //println(m.mkString(","))
        //println(result.mkString(","))
        //println("------")
        m
    }
}