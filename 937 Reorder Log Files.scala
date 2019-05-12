object Solution {
    def reorderLogFiles(logs: Array[String]): Array[String] = {
        val (letter, digit) = logs.partition(log => {
            val w = log.split(" ", 3)(1)
            !w(0).isDigit
        })
        
        val letter_ordered = letter.sortBy(log=> {
            val w = log.split(" ", 2)
            (w(1), w(0))
        })
        
        letter_ordered ++ digit
    }
}