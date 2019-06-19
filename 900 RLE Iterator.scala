class RLEIterator(_A: Array[Int]) {
    var i = 0

    def next(n: Int): Int = {
        var x = n
        while (i< _A.length && _A(i)<x) {
            x-= _A(i)
            i+= 2
        }
        if (i< _A.length) { _A(i) -= x; _A(i+1)}
        else -1
    }

}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * var obj = new RLEIterator(A)
 * var param_1 = obj.next(n)
 */