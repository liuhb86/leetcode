object Solution {
    
    val f = Array(0,1,1,2,3,5,8,13,21,34,55,89,144,233,377,610,987,1597,2584,4181,6765,10946,17711,28657,46368,75025,121393,196418,317811,514229,832040)
    def fib(N: Int): Int = {
        f(N)
    }
    
    def calc() {
        val f = new Array[Int](31)
        f(0) = 0
        f(1) = 1
        for (n <- 2 to 30) {
            f(n) = f(n-1) + f(n-2)     
        }
        f.foreach(x => print(s"$x,"))
    }
}