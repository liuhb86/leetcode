//f(2) = 1/2
//if f(x) = 1/2 for 2...n-1, then
//f(n) = 1/n * 1 + 1/n(f(n-1) +...+f(2)) + 1/n * 0
/      = 1/n + (n-2)/2n = 1/2
object Solution {
    def nthPersonGetsNthSeat(n: Int): Double = {
        if (n==1) 1 else .5
    }
}
