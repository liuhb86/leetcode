import scala.collection.Searching._

class TopVotedCandidate(_persons: Array[Int], _times: Array[Int]) {
    
    val n = _persons.length
    val votes = Array.fill(n)(0)
    val rank = (0 until n).toArray
    val sorted = (0 until n).toArray
    val lead = new Array[Int](n)
    
    var nextStat = 0
    
    def update(index: Int) : Int = {
        for (i <- nextStat to index) {
            val person = _persons(i)
            votes(person) += 1
            val vote = votes(person)
            var r = rank(person)
            while (r > 0 && vote >= votes(sorted(r - 1))) {
                val p2 = sorted(r -1)
                rank(p2) = r
                sorted(r) = p2
                r -= 1
            }
            rank(person) = r
            sorted(r) = person
            lead(i) = sorted(0)
        }
        nextStat = List(index + 1, nextStat).max
        lead(index)
    }
    
    def q(t: Int): Int = {
        val index = _times.search(t) match {
            case Found(idx) => idx
            case InsertionPoint(idx) => idx -1
        }
        update(index)
    }

}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * var obj = new TopVotedCandidate(persons, times)
 * var param_1 = obj.q(t)
 */