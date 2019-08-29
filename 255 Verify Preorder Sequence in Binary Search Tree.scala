object Solution {
    def verifyPreorder(preorder: Array[Int]): Boolean = {
        var limit : Option[Int] = None
        var i = -1
        for (n<-preorder) {
            if (limit.isDefined && n < limit.get) return false
            while (i>=0 && n > preorder(i)) {
                limit = Some(preorder(i));
                i -= 1; 
            }
            i += 1
            preorder(i) = n
        }
        true
    }
}