object Solution {
    def trap(height: Array[Int]): Int = {
        var r = 0
        var i = 0
        var j = height.length - 1
        while (i<j) {
            if (height(i) < height(j)) {
                var p = i+1
                while (p<j && height(p)<height(i)) {
                    r += height(i) - height(p)
                    p +=1
                }
                i = p
            } else {
                var p = j-1
                while (p>i && height(p)<height(j)) {
                    r += height(j) - height(p)
                    p -= 1
                }
                j = p
            }
        }
        r
    }
}