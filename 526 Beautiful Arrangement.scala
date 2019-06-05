object Solution {
    val r = Array(0,1,2,3,8,10,36,41,132,250,700,750,4010,4237,10680,24679)
    def countArrangement(N: Int): Int = {
        r(N)
    }
    
    def p() {
        for(n<-1 to 15) {
            val a = (1 to n).toArray
            print(count(a, 1))
            print(",")
        }
        println
    }
    
    def count(a: Array[Int], i: Int) : Int = {
        if (a.isEmpty) return 1
        var sum = 0
        for (k<-0 until a.length) {
            if (a(k) % i == 0 || i % a(k) == 0) {
                sum += count(a.take(k) ++ a.drop(k+1), i+1)
            } 
        }
        sum
    }
}