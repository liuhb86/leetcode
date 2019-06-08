object Solution {
    def totalFruit(tree: Array[Int]): Int = {
        if (tree.isEmpty) return 0
        var type1 = tree.head
        var start1 = 0
        var type2 = tree.head
        var start2 = 0
        var maxAmount = 0
        for (i<-tree.indices) {
            val t = tree(i)
            if (t != type1) {
                if (t!=type2) {
                    maxAmount = maxAmount.max(i-start2)
                    start2 = start1
                }
                type2 = type1
                type1 = t
                start1 = i
            }
        }
        maxAmount = maxAmount.max(tree.length - start2)
        maxAmount
    }
}

/*
if (t != type1) {
                if (t==type2) {
                    type2 = type1
                    type1 = t
                    start1 = i
                } else {
                    maxAmount = maxAmount.max(i-start2)
                    type2 = type1
                    type1 = t
                    start2 = start1
                    start1 = i
                }
            }
*/