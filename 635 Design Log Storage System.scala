import java.util.TreeMap
import scala.collection.JavaConverters._
class LogSystem() {
  val map = new TreeMap[String, Int]()

  def put(id: Int, timestamp: String) {
    map.put(timestamp, id)
  }

  val gmap = Map("Year" -> 4, "Month" -> 7, "Day" -> 10,
    "Hour" -> 13, "Minute" ->16, "Second" -> 19)

  def retrieve(s: String, e: String, gra: String): List[Int] = {
    val g = gmap(gra)
    val s1 = s.substring(0, g) ++ "0" * (s.length - g)
    val e1 = e.substring(0, g) ++ "Z" * (e.length - g+1)
    val range = map.subMap(s1,e1)
    range.values().asScala.toList
  }

}

/**
  * Your LogSystem object will be instantiated and called as such:
  * var obj = new LogSystem()
  * obj.put(id,timestamp)
  * var param_2 = obj.retrieve(s,e,gra)
  */