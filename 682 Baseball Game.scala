object Solution {
    def calPoints(ops: Array[String]): Int = {
        val s = scala.collection.mutable.ArrayBuffer[Int]()
        for (op<-ops) {
            op match {
                case "+" => s += s.last + s(s.length -2)
                case "D" => s += s.last * 2
                case "C" => s.trimEnd(1)
                case x => s += x.toInt
            }
        }
        s.sum
    }
}