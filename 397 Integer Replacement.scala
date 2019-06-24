object Solution {
    def integerReplacement(n: Int): Int = {
        var r = 0
        var x = n.toLong
        while (x > 1) {
            r+=1
            if ((x& 1)==0) x>>=1
            else if ((x&2)==0 || x==3) x-=1
            else x+=1
        }
        r
    }
}