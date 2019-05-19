import scala.collection.mutable.ListBuffer
object Solution {
    def canFinish(numCourses: Int, prerequisites: Array[Array[Int]]): Boolean = {
        val depends = Array.fill(numCourses)(0)
        val g = Array.fill(numCourses)(new ListBuffer[Int])
        for (p <- prerequisites) {
            g(p(1)) += p(0)
            depends(p(0)) += 1
        }
        val nextCourses = ListBuffer(depends.zipWithIndex.filter(_._1 == 0).map(_._2):_*)
        var remain = numCourses - nextCourses.length
        if ( remain == 0) return true
        while(!nextCourses.isEmpty) {
            val c = nextCourses.head
            nextCourses.trimStart(1)
            for (n <- g(c) if depends(n) > 0) {
                depends(n) -= 1
                if (depends(n) == 0) {
                    remain -= 1
                    if (remain == 0) return true
                    nextCourses += n
                }
            }
        }
        return false
    }
}