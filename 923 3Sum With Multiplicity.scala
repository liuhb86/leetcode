import scala.util.control.Breaks._
object Solution {
    val M = 1000000007L
    def threeSumMulti(A: Array[Int], target: Int): Int = {
        val m = A.groupBy(identity).mapValues(_.length.toLong)
        val s = m.keySet.toArray.sorted
        var r = 0L
        breakable {for (i<-s.indices) {
            val vi = s(i)
            if (vi > target/3) break
            val tvi = target - vi
            breakable {for (j<- i+1 until s.length) {
                val vj = s(j)
                val vk = tvi - vj
                if (vk < vj) break
                if (vk == vj) {
                    val a = m(vi)*m(vj)*(m(vj) - 1)/2
                    //println(s"$vi $vj $vk $a")
                    r = (r + a) % M
                } else if (m.contains(vk)) {
                    val a = m(vi)*m(vj)*m(vk)
                    //println(s"$vi $vj $vk $a")
                    r = (r + a) % M
                }
            }}
        }}
        
        breakable { for (i<- s.indices) {
            val vi = s(i)
            val vj = target - vi - vi
            if (vj < vi) break
            if (vj == vi) {
                val a = m(vi)*(m(vi)-1)*(m(vi)-2)/6
                //println(s"$vi $vi $vj $a")
                r = (r + a) % M 
            } else if (m.contains(vj)) {
                val a = m(vi)*(m(vi) - 1)*m(vj)/2
                //println(s"$vi $vi $vj $a")
                r = (r + a) % M
            }
        }}
        
        r.toInt
    }
    
}