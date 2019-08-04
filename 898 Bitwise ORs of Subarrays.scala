import scala.collection.mutable.Set
object Solution {
    def subarrayBitwiseORs(A: Array[Int]): Int = {
        val set = Set[Int]()
        var sr = Set[Int]()
        var k = 0
        var r = 0
        for (n<-A) {
            var k1 = 0
            val sr2 = Set[Int]()
            for (t<- sr) {
                val x = t | n
                if (set.add(x)) r += 1
                sr2 += x
            }
            if (set.add(n)) r+=1
            sr2 += n
            sr = sr2
        }
        r
    }
}