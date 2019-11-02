object Solution {
    def balancedStringSplit(s: String): Int = {
        var b = 0
        var r = 0
        for (c<-s) {
            if (c=='L') b += 1 else b-=1
            if (b ==0) r += 1
        }
        r
    }
}