object Solution {
    def strongPasswordChecker(s: String): Int = {
        var len = s.length
        var last = '\0'
        var count = 0
        var mod = 0
        val toDelete = scala.collection.mutable.ArrayBuffer[Int]()
        for (i<-s.indices) {
            val c = s(i)
            if (c==last) {
                count += 1
                if (count == 3) {
                    if(len > 20) {
                        toDelete += count
                    } else if (len < 6) {
                        // insert
                        mod += 1 ; count = 1; len += 1
                    } else {
                        // replace
                        mod += 1; count = 0
                    }
                } else if (count > 3) {
                    toDelete(toDelete.length - 1) = count
                }
            } else {
                count = 1
            }
            last = c
        }
        if (len<6) mod += (6-len)
        
        var del = 0
        if (toDelete.nonEmpty) {
            var arr = toDelete.toArray
            var i = 0
            while (len > 20 && i<arr.length) {
                if (arr(i) % 3 == 0) {
                    del += 1; len -= 1; arr(i) -=1
                }
                i+=1
            }
            i = 0
            while (len > 20 && i<arr.length) {
                if (arr(i) % 3 == 1) {
                    val d = 2.min(len-20)
                    del += d; len -= d; arr(i) -=d
                }
                i+=1
            }
            //arr = arr.sorted
            i = 0
            while (len > 20 && i<arr.length) {
                val d = (arr(i)-2).min(len-20)
                del += d; len -=d; arr(i) -=d
                i+= 1
            }
            for (i<-arr.indices) {
                mod += arr(i)/3
            }
        }
        if (len > 20) del += (len -20)
        
        var cmod = 0
        if (s.indexWhere(_.isUpper) < 0) {len += 1; cmod +=1}
        if (s.indexWhere(_.isLower) < 0) {len += 1; cmod +=1}
        if (s.indexWhere(_.isDigit) < 0) {len += 1; cmod +=1}
        
        mod.max(cmod) + del
    }
}