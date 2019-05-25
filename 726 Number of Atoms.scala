import scala.collection.mutable.{Map, StringBuilder}
object Solution {
    def countOfAtoms(formula: String): String = {
        val it = formula.toIterator.buffered
        (count(it).toArray.sortBy(_._1).map{
            case (k, 1) => k
            case (k, v) => k + v.toString
        }).mkString
    }
    
    def getNumber(it: BufferedIterator[Char]) : Int = {
        if (!(it.hasNext && it.head.isDigit)) return 1
        val nb = new StringBuilder
        nb += it.next()
        while(it.hasNext && it.head.isDigit) nb += it.next()
        nb.toInt
    }
    
    def count(it: BufferedIterator[Char]) : Map[String, Int] = {
        val map = Map[String, Int]()
        while(it.hasNext) {
            if (it.head.isLetter) {
                val eb = new StringBuilder
                eb += it.next()
                while(it.hasNext && it.head.isLower) eb += it.next()
                val element = eb.toString
                val n = getNumber(it)
                map(element) = map.getOrElse(element, 0) + n
            } else if (it.head == '(') {
                it.next
                val r = count(it)
                //println("r1")
                //println(r.toArray.mkString)
                for ((k,v) <- r) {
                    map(k) = map.getOrElse(k, 0) + v
                }
                //println("r1")
                //println(map.toArray.mkString)
            } else {  // )
                it.next
                val n =  getNumber(it)
                //println("m1")
                //println(map.toArray.mkString)
                for ((k,v) <- map) {
                    map(k) = v * n
                }
                //println("m2")
                //println(map.toArray.mkString)
                return map
            }
        }
        map
    }
}