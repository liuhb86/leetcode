import scala.annotation.tailrec
object Solution {
    def numSubarraysWithSum(A: Array[Int], S: Int): Int = {
        val n = A.length
        var r = 0
        if (S == 0) {
            var i = 0
            while (i<n && A(i) == 1) i+=1
            while (i<n) {
                var j = i + 1
                while (j<n && A(j)== 0) j += 1
                r += (j-i +1) *(j-i)/2
                i = j
                while(i<n&&A(i)==1) i+=1
            }
        } else {
            var a = 0
            var i = 0
            while(i<n && A(i) == 0) i+=1
            var j = i 
            var k = 0
            while(j<n && k < S) {k += A(j); j+=1}
            if (k<S) return 0
            j -= 1
            var b = j+1
            while(b<n && A(b)==0) b+=1
            while(j<n) {
                r += (i-a +1) * (b-j)
                //println(s"$a,$i,$j,$b,$r")
                a = i + 1
                i = a
                while(i<n&&A(i)==0) i+=1
                j = b
                b = j+ 1
                while(b<n && A(b)==0) b+=1
            }
        }
        r
    }
}