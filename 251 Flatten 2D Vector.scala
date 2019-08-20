class Vector2D(_v: Array[Array[Int]]) {
   
    var i = 0
    var j = 0
    
    seek()
    
    def next(): Int = {
        val v = _v(i)(j)
        j += 1
        seek()
        v
    }
    
    def seek() {
        while(i<_v.length) {
            if (j < _v(i).length) return
            j = 0
            i += 1
        }
    }

    def hasNext(): Boolean = {
        i < _v.length
    }

}

/**
 * Your Vector2D object will be instantiated and called as such:
 * var obj = new Vector2D(v)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */