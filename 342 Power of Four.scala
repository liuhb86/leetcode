object Solution {
    def isPowerOfFour(num: Int): Boolean = {
        num>0 && (num & (num-1)) == 0 && (Integer.numberOfTrailingZeros(num) & 1) == 0
    }
}