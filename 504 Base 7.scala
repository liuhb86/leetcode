object Solution {
    def convertToBase7(num: Int): String = {
        if (num ==0) return "0"
        var x = if (num>0) num else -num
        var d : List[Char] = Nil
        while(x >0) {
            d = (x%7 + '0').toChar :: d
            x = x/7
        }
        if (num <0) d = '-' :: d
        d.mkString
    }
}