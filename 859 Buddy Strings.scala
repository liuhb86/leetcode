object Solution {
    def buddyStrings(A: String, B: String): Boolean = {
        if (A.length != B.length) return false
        var swapped = 0
        var ca ='a'
        var cb='b'
        for (i<-A.indices) {
            if (A(i) != B(i)) {
                if (swapped == 0) {
                    ca = A(i)
                    cb = B(i)
                    swapped = 1
                } else if (swapped == 1 && A(i)==cb && B(i)==ca) {
                    swapped = 2
                } else {
                    return false
                }
            }
        }
        swapped == 2 || (swapped == 0 && A.toSet.size < A.length)
    }
}