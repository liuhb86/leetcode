import scala.collection.mutable.Map
class Logger() {

    /** Initialize your data structure here. */
    var mapOld = Map[String, Int]()
    var mapNew = Map[String, Int]()
    var timeNew = Int.MinValue

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    def shouldPrintMessage(timestamp: Int, message: String): Boolean = {
        if (timestamp >= timeNew + 20) {
            mapOld.clear()
            mapNew.clear()
            timeNew = timestamp
        }
        if (timestamp >= timeNew + 10) {
            val t = mapOld; mapOld = mapNew; mapNew = t
            mapNew.clear()
            timeNew = timestamp
        }
        if (mapNew.contains(message)) return false
        val t2 = mapOld.get(message)
        if (t2.isDefined && timestamp < t2.get + 10) return false
        mapNew(message) = timestamp
        true
    }

}

/**
 * Your Logger object will be instantiated and called as such:
 * var obj = new Logger()
 * var param_1 = obj.shouldPrintMessage(timestamp,message)
 */