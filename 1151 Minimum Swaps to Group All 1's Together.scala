object Solution {
    def minSwaps(data: Array[Int]): Int = {
        val n = data.count(_==1)
        var nz = 0
        for (i<-0 until n) if (data(i)==0) nz +=1
        var r = nz
        var i = 0
        var j = n
        while (j < data.length) {
            if (data(i)==0) nz -=1
            i+=1
            if (data(j)==0) nz+=1
            j+=1
            r = r.min(nz)
        }
        r
    }
}