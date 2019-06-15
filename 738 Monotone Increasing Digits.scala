object Solution {
    def monotoneIncreasingDigits(N: Int): Int = {
        val s = N.toString.toArray
        var i = 0
        while (i < s.length -1 && s(i)<=s(i+1)) i+=1
        if (i<s.length -1) {
            while (i>0 && s(i)==s(i-1)) i-=1
            s(i) = (s(i) - 1).toChar
            for (j<- i+1 until s.length) s(j) = '9'
        }
        s.mkString.toInt
    }
}