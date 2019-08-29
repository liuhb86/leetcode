import scala.collection.mutable.{Set, Map, Queue}
object Solution {
    def invalidTransactions(transactions: Array[String]): List[String] = {
        val set = Set[String]()
        val g = transactions.map(x => {
            val s = x.split(",")
            (s(0), s(1).toInt, s(2).toInt, s(3), x)})
            .groupBy(_._1).values
        for (u<-g) {
            val s = u.sortBy(_._2)
            for (t<-s) {
                if (t._3 >1000) set += t._5
            }
            val m1 = Map[String, Int]()
            val q1 = Queue[(String, Int, Int, String, String)]()
            for (t<-s) {
                while (q1.nonEmpty && q1.head._2 < t._2 - 60) {
                    if (m1(q1.head._4) == 1) {
                        m1 -= q1.head._4
                    } else {
                        m1(q1.head._4) -= 1
                    }
                    q1.dequeue
                }
                q1 += t
                m1(t._4) = m1.getOrElse(t._4, 0) + 1
                if (m1.size > 1) set += t._5
            }
            
            m1.clear()
            q1.clear()
            for (t<-s.reverse) {
                while (q1.nonEmpty && q1.head._2 > t._2 + 60) {
                    if (m1(q1.head._4) == 1) {
                        m1 -= q1.head._4
                    } else {
                        m1(q1.head._4) -= 1
                    }
                    q1.dequeue
                }
                q1 += t
                m1(t._4) = m1.getOrElse(t._4, 0) + 1
                if (m1.size > 1) set += t._5
            }
        }
        set.toList
    }
}