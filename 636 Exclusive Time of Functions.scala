object Solution {
    def exclusiveTime(n: Int, logs: List[String]): Array[Int] = {
        val stack = scala.collection.mutable.ArrayBuffer[(Int, Int)]()
        val r = new Array[Int](n)
        for(log<-logs) {
            val Array(fs, tag, ts) = log.split(":")
            val f= fs.toInt
            val t = ts.toInt
            if (tag == "start") {
                if (stack.nonEmpty) {
                    r(stack.last._1) += (t-stack.last._2)
                }
                stack += ((f,t))
            } else {
                r(stack.last._1) += (t-stack.last._2+1)
                stack.trimEnd(1)
                if (stack.nonEmpty) {
                    stack(stack.length - 1) = (stack.last._1, t+1)
                }
            }
        }
        r
    }
}