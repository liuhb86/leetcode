object Solution {
    def lemonadeChange(bills: Array[Int]): Boolean = {
        var n5 = 0
        var n10 = 0
        for (b<-bills) {
            b match {
                case 5 =>
                    n5+=1
                case 10 =>
                    if (n5 == 0) return false
                    n5-=1
                    n10+=1
                case 20 =>
                    if (n10 > 0 && n5>0) {
                        n10-=1
                        n5-=1
                    } else if (n5>=3) {
                        n5-=3
                    } else {
                        return false
                    }
            }
        }
        true
    }
}