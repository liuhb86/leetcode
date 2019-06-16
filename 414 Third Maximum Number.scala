object Solution {
    def thirdMax(nums: Array[Int]): Int = {
        var m1 : Option[Int] = None
        var m2 = m1
        var m3 = m1
        for (n<-nums) {
            val s = Some(n)
            if (s==m1 || s==m2 || s==m3) {
                // do nothing
            } else if (m1.isEmpty || n>m1.get) {
                m3 = m2;m2=m1;m1=s
            } else if (m2.isEmpty || n>m2.get) {
                m3 = m2;m2=s
            } else if (m3.isEmpty || n >m3.get) {
                m3 = s
            }
        }
        m3.getOrElse(m1.get)
    }
}