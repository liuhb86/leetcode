object Solution {
    def shortestPalindrome(s: String): String = {
        if (s.isEmpty) return s
        val t = new Array[Int](s.length / 2)
        for (i<- 1 until t.length) {
            var p = i
            while (p> 0) {
                p = t(p-1)
                if (s(i) == s(p)) t(i) = p + 1
            }
        }
        //println(t.mkString(" "))
        var i = 0
        var j = s.length -1
        while (i<j) { 
            //println(i,j)
            if (s(i) == s(j)) {
                i+=1; j-=1
            } else {
                if (i==0) {
                    j-=1
                } else {
                    i = t(i-1)  
                }
            }
        } 
        
        val d = if (j==i) s.length - i - i - 1
                else s.length - i - i
        return s.takeRight(d).reverse + s
    }
}