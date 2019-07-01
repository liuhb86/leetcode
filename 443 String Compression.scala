object Solution {
    def compress(chars: Array[Char]): Int = {
        if (chars.isEmpty) return 0
        var j = 0
        var c=1
        var k = 1
        var p = 10
        for (i<- 1 to chars.length) {
            if (i< chars.length && chars(i)==chars(j)) {
                c+=1
                if (c==p) {
                    p*=10
                    k+=1
                }
            } else {
                if (c>1) {
                    for(d<- k to 1 by -1) {
                        chars(j+d) = ((c % 10) + '0').toChar
                        c/=10
                    }
                    j+= (k+1)
                } else {
                    j += 1
                }
                if (i< chars.length) chars(j) = chars(i)
                k = 1
                p = 10
                c= 1
            }  
        }
        j
    }
}