object Solution {
    def numRabbits(answers: Array[Int]): Int = {
        var total = 0
        val groups = answers.groupBy(identity).mapValues(_.length)
        for ((k,v)<-groups) {
            val groupSize = k + 1
            val nGroups = if (v % groupSize == 0) v / groupSize else v /groupSize + 1
            total += nGroups * groupSize
        }
        total
    }
}