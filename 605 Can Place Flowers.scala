object Solution {
    def canPlaceFlowers(flowerbed: Array[Int], n: Int): Boolean = {
        if (n == 0) return true
        var last = 0
        var nz = 0
        var nf = 0
        for (f<- flowerbed) {
            if (f==0) {
                if (last == 1) {
                    nz = 0
                } else {
                    if (nz == 0) {
                        nz = 1
                    } else {
                        nz = 0
                        nf += 1
                        if (nf >= n) return true
                    }
                }
            }
            last = f
        }
        if (last == 0 && nz ==1 && nf  + 1 >=n) return true 
        false
    }
}