object Solution {
    def minimumDeleteSum(s1: String, s2: String): Int = {
        var dp0 = new Array[Int](s2.length + 1)
        var dp = new Array[Int](s2.length + 1)
        dp0(0) = 0
        for (i<- s2.indices) dp0(i+1) = dp0(i) + s2(i)
        //println(dp0.mkString(" "))
        for (i<- s1.indices) {
            dp(0) = dp0(0) + s1(i)
            for (j<-s2.indices) {
                dp(j+1) = 
                    if (s1(i) == s2(j)) dp0(j)
                    else (dp(j) + s2(j)).min(dp0(j+1) + s1(i))
            }
            val t = dp0; dp0 = dp; dp = t
            //println(dp0.mkString(" "))
        }
        dp0(s2.length)
    }
}