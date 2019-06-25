import scala.collection.mutable.Map
object Solution {
    val pat = raw"(.*)\((.*)\)".r
    def findDuplicate(paths: Array[String]): List[List[String]] = {
        val map = Map[String, List[String]]()
        for (p<-paths) {
            val splits = p.split(" ")
            val dir = splits.head
            val files = splits.tail
            for (f<-files) {
                f match {
                    case pat(name, content) => map(content) = s"$dir/$name" :: map.getOrElse(content, Nil)
                }
            }
        }
        map.values.filter(_.tail != Nil).toList
    }
}