// peek
object Solution {
    def isPossible(nums: Array[Int]): Boolean = {
        var c1 = 0
        var c2 = 0
        var c3 = 0
        var c = 0
        var p = nums.head
        var cont = false
        for (i<- 0 to nums.length) {
            if (i< nums.length && nums(i)==p) c+=1
            else {
                if (!cont) {
                    if (c1>0 || c2>0) return false
                    c1 = c; c2 = 0; c3=0
                } else {
                    if (c < c1+c2) return false
                    val nc2 = c1
                    val nc1 = (c - c1 - c2 - c3).max(0)
                    val nc3 = c2 + c3.min(c-c1-c2)
                    c1 = nc1; c2 = nc2; c3 = nc3;
                }
                if (i< nums.length) {
                    cont = (nums(i) == p + 1)
                    c = 1
                    p = nums(i)
                }
                //println(c1,c2,c3)
            }
        }
        c1 == 0 && c2 == 0
    }
}