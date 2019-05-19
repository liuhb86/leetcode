object Solution {
    val happy = Set(1,7,10,13,19,23,28,31,32,44,49,68,70,79,82,86,91,94,97,100,103,109,129,130,133,139,167,176,188,190,192,193)
    
     def isHappy(n: Int): Boolean = {
        var x = n
        while (x > 200) {
            var t = 0
            while (x > 0) {
                val d = x % 10
                t += d * d
                x = x / 10
            }
            x = t
        }
        happy.contains(x)
    }
    
    def __isHappy(n: Int): Boolean = {
        println("(")
        for (i<- 1 until 200) {
            if (_isHappy(i)) print(s"$i,")
        }
        false
    }
    
    def _isHappy(n: Int): Boolean = {
        val s = scala.collection.mutable.Set[Int]()
        var x = n
        while (x != 1 && !s.contains(x)) {
            s += x
            var t = 0
            while (x > 0) {
                val d = x % 10
                t += d * d
                x = x / 10
            }
            x = t
        }
        x == 1
    }
}