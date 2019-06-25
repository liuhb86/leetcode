object Solution {
    def minAddToMakeValid(S: String): Int = {
        var b = 0
        var c = 0
        for (x<-S) {
            if (x =='(') {
                b+=1
            } else {
                if (b > 0) b-=1
                else c+=1
            }
        }
        c + b
    }
}