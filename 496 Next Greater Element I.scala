object Solution {
    def nextGreaterElement(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
        val s= scala.collection.mutable.ArrayBuffer[Int]()
        val map = scala.collection.mutable.Map[Int,Int]()
        for (i<-nums2.indices) {
            while(s.nonEmpty && nums2(i) > nums2(s.last)) {
                map(nums2(s.last)) = nums2(i)
                s.trimEnd(1)
            }
            s += i
        }
        nums1.map(x=> map.getOrElse(x, -1))
    }
}