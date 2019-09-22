import scala.collection.mutable.Set
object Solution {
    def minimumSemesters(N: Int, relations: Array[Array[Int]]): Int = {
        val pre = Array.fill(N+1)(Set[Int]())
        val next = Array.fill(N+1)(Set[Int]())
        for(Array(a,b)<-relations) {
            next(a) += b
            pre(b) += a
        }
        var list = (1 to N).filter(pre(_).isEmpty).toList
        var left = N
        var r = 0
        while(list.nonEmpty) {
            r +=1
            var nextList : List[Int] = Nil
            for (c<-list) {
                left -= 1
                for (n<-next(c)) {
                    pre(n) -= c
                    if (pre(n).isEmpty) nextList = n :: nextList
                }
            }
            list = nextList
        }
        if (left == 0) r else -1
    }
}