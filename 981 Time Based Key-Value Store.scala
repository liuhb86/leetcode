import scala.collection.mutable.Map
import java.util.TreeMap
class TimeMap() {

    /** Initialize your data structure here. */
    val map = Map[String, TreeMap[Int, String]]()

    def set(key: String, value: String, timestamp: Int) {
        val vm = map.getOrElseUpdate(key, new TreeMap[Int, String]())
        vm.put(timestamp,value)
    }

    def get(key: String, timestamp: Int): String = {
        val vm = map.get(key)
        if (vm.isEmpty) return ""
        val v = vm.get.floorEntry(timestamp)
        if (v == null) return ""
        v.getValue
    }

}

/**
 * Your TimeMap object will be instantiated and called as such:
 * var obj = new TimeMap()
 * obj.set(key,value,timestamp)
 * var param_2 = obj.get(key,timestamp)
 */