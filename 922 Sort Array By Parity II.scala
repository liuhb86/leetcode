object Solution {
    def sortArrayByParityII(A: Array[Int]): Array[Int] = {
        var i = 0
        var j = 1
        while (i < A.length) {
            while (i < A.length && A(i) % 2 == 0) i += 2
            while (j < A.length && A(j) % 2 == 1) j += 2
            if (i < A.length) {
                val t = A(i); A(i) = A(j); A(j) = t
                i+=2; j+=2
            }
        }
        A
    }
}