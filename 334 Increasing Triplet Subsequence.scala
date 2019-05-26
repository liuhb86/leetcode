object Solution {
    def increasingTriplet(nums: Array[Int]): Boolean = {
        if (nums.length < 3) return false
        var m1 = nums(0)
        var m2 : Option[Int] = None
        for (i <- 1 until nums.length) {
            val n = nums(i)
            if (m2.isDefined && n > m2.get) return true
            if (n > m1) {
                if (m2.isEmpty || n < m2.get) m2 = Some(n)
            } else if (n < m1) {
                m1 = n
            }
        }
        false
    }
}