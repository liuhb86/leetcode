import java.util.{TreeMap,Collections}
import scala.collection.mutable.Map
import scala.collection.JavaConverters._
class Leaderboard() {

    val scoreMap = new TreeMap[Int, Int](Collections.reverseOrder[Int]())
    val idMap = Map[Int, Int]()
    def addScore(playerId: Int, score: Int) {
        val r = idMap.get(playerId)
        var nv = score
        if (r.isDefined) {
            val v = r.get
            val c = scoreMap.get(v)
            if (c > 1) {
                scoreMap.put(v, c -1)
            } else {
                scoreMap.remove(v)
            }
            nv += v
        }
        idMap(playerId) = nv
        scoreMap.put(nv, scoreMap.getOrDefault(nv, 0) + 1)
    }

    def top(K: Int): Int = {
        var i = K
        var s = 0
        for (e<-scoreMap.entrySet.iterator.asScala) {
            if (i == 0) return s
            val c = e.getValue.min(i)
            s += e.getKey * c
            i -= c
        }
        s
    }

    def reset(playerId: Int) {
        val v = idMap(playerId)
        idMap -= playerId
        val c = scoreMap.get(v)
        if (c==1) {
            scoreMap.remove(v)
        } else {
            scoreMap.put(v, c-1)
        }
    }

}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * var obj = new Leaderboard()
 * obj.addScore(playerId,score)
 * var param_2 = obj.top(K)
 * obj.reset(playerId)
 */