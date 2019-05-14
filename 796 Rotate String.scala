object Solution {
    def rotateString(A: String, B: String): Boolean = {
        if (A.length != B.length) return false
        for (i<-0 to A.length) {
            if (A.drop(i) == B.dropRight(i) && A.take(i) == B.takeRight(i)) return true
        }
        false
    }
}