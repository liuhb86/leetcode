object Solution {
    def sumOfDigits(A: Array[Int]): Int = {
        val S = A.min.toString.map(_-'0').sum
        if (S % 2 == 0) 1 else 0
    }
}