object Solution {
    def optimalDivision(nums: Array[Int]): String = {
        if (nums.length == 1) return nums.head.toString
        if (nums.length == 2) return s"${nums(0)}/${nums(1)}"
        s"${nums.head}/(${nums.tail.mkString("/")})"
    }
}