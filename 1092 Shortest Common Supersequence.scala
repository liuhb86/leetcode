object Solution {
    def shortestCommonSupersequence(str1: String, str2: String): String = {
        if (str1.isEmpty) return str2
        if (str2.isEmpty) return str1
        val dp = new Array[Array[(Int, List[Char])]](str1.length+1)
        dp(0) = new Array[(Int, List[Char])](str2.length+1)
        dp(0)(0) = (0, Nil)
        for (i<-1 to str2.length) dp(0)(i) = (i, str2(i-1) :: dp(0)(i-1)._2)
        for (i<-1 to str1.length) {
            dp(i) = new Array[(Int, List[Char])](str2.length+1)
            val c1 = str1(i-1)
            dp(i)(0) = (i, c1 :: dp(i-1)(0)._2)
            for (j<-1 to str2.length) {
                val c2 = str2(j-1)
                if (c1==c2) {
                    val p = dp(i-1)(j-1)
                    dp(i)(j) = (p._1 + 1, c1 :: p._2)
                } else {
                    val p1 = dp(i-1)(j)
                    val p2 = dp(i)(j-1)
                    if (p1._1 <= p2._1) {
                        dp(i)(j) = (p1._1 +1, c1 :: p1._2)
                    } else {
                        dp(i)(j) = (p2._1+1, c2::p2._2)
                    }
                }
            }
        }
        dp(str1.length)(str2.length)._2.reverse.mkString
    }
}