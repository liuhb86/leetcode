object Solution {
    def duplicateZeros(arr: Array[Int]): Unit = {
        var i = 0
        var j = 0
        while (j<arr.length) {
            if (arr(i)!=0) {
                j+=1
            } else {
                j+=2
            }
            i+=1
        }
        
        for (k<-i-1 to 0 by -1) {
            val v = arr(k)
            if (v!=0) {
                j-=1
                arr(j) = v
            } else {
                j-=1
                if(j < arr.length) arr(j) = 0
                j-=1
                arr(j) = 0
            }
        }
    }
}