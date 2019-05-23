object Solution {
    def shortestCompletingWord(licensePlate: String, words: Array[String]): String = {
        var shortest : String = null
        val p = licensePlate.toLowerCase.filter(c=> c.isLetter)
        for (w <- words) {
            if (shortest == null || w.length < shortest.length) {
                val d = p.intersect(w)
                if (d.length == p.length) {
                    if (shortest == null || w.length < shortest.length) {
                        shortest = w
                    }
                }
            }
        }
        shortest
    }
}