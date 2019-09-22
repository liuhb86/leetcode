object Solution {
    def numberOfDays(Y: Int, M: Int): Int = {
        if (M > 7) {
            if (M % 2==0) return 31
            else return 30
        }
        if (M!=2) {
            if (M % 2 ==0) return 30
            else return 31
        }
        if (Y % 4 ==0 && (Y%400==0 || Y%100!=0)) return 29
        else 28
    }
}