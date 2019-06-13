object Solution {
    def rotatedDigits(N: Int) : Int = {
        var p = 1
        while (p<= N/10) {
            p *= 10
        }
        rotate(N, p)._2
    }
    
    val s1 = Set(2,5,6,9)
    val s2 = Set(0,1,8)
    
    def rotate(N: Int, p: Int) : (Int, Int) = {
        if (p==0) return (1,0)
        val a = N / p
        val b = N % p
        val c1 = rotate(p-1, p/10)
        val c2 = rotate(b, p/10)
        var r1 = 0
        var r2 = 0
        for (i<-0 to a) {
            val c = if (i==a) c2 else c1
            if (s1.contains(i)) {
                r1+=c._1
                r2+=c._1
            } else if (s2.contains(i)) {
                r1+=c._1
                r2+=c._2
            }
        }
        (r1,r2)
    }
    
    
    /*
    def rotatedDigits(N: Int): Int = {
        (2 to N).count(isGood)
    }
    
    def isGood(x: Int): Boolean = {
        val t = new Array[Boolean](10)
        x.toString.foreach(c => t(c-'0')=true)
        !t(3) && !t(4) && !t(7) &&(t(2) || t(5) || t(6) || t(9))
    }
    */
}