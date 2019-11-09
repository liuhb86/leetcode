object Solution {
    def transformArray(arr: Array[Int]): List[Int] = {
        var arr1 = arr
        var arr2 = new Array[Int](arr.length)
        arr2(0) = arr1(0); arr2(arr.length -1) = arr1(arr.length -1)
        var changed = true
        while(changed) {
            changed = false
            for (i<-1 until arr.length -1) {
                if (arr1(i) < arr1(i-1) && arr1(i) < arr1(i+1)) {
                    arr2(i) = arr1(i) + 1
                    changed = true
                } else if (arr1(i) > arr1(i-1) && arr1(i) > arr1(i+1)) {
                    arr2(i) = arr1(i) - 1
                    changed = true
                } else {
                    arr2(i) = arr1(i)
                }
            }
            val t = arr1; arr1 = arr2; arr2 = t
        }
        arr2.toList
    }
}