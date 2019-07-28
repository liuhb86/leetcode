object Solution {
    def reverseOnlyLetters(S: String): String = {
        val a = S.toArray
        var i = 0
        var j = a.length - 1
        while (i < j) {
            while (i<j && !a(i).isLetter) i += 1
            while (i<j && !a(j).isLetter) j -= 1
            if (i<j) {
                val t=a(i); a(i)=a(j); a(j)=t
                i+=1; j-=1
            }
        }
        a.mkString
    }
}