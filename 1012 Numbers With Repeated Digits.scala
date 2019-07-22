object Solution {
    def numDupDigitsAtMostN(N: Int): Int = {
        
        // 8xx : 
        //       799 :8-1 * c(9, k-1) +
        //       8xy: x<=8  8(x-1)99
        //            x>8 (x<=8) + 
        val s = N.toString
        var r = 0
        val less = n9(s.length -1)
        val used = new Array[Boolean](10)
        val eq = ne(s, used, 0)
        N - less - eq
    }
    
    def ne(s: String, used: Array[Boolean], nUsed : Int) : Int = {
        if (s.isEmpty) return 1
        val n = s.head - '0'
        val start = if (nUsed == 0) 1 else 0
        val less = (start to (n-1)).filter(x => !used(x)).length
        var r = less * a(9-nUsed, s.length - 1)
        if (!used(n)) {
            used(n) = true
            r += ne(s.tail, used, nUsed+1)
        }
        //println(r)
        r
    }
    
    def a(n: Int, k:Int) : Int = {
        var r = 1
        for (i<- n to (n-k+1) by -1 ) {
            r *= i
        }
        //if (n==8 && k==2) println("a82", r)
        r
    }
    
    def n9(k: Int) : Int = {
        // 999: 9 * a(9,k-1)
        var r = 0
        var p = 1
        var m = 9
        for (i<-0 until k) {
            r += p
            p*=m
            m-=1
        }
        r * 9
    }
}