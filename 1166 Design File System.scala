class FileSystem() {

    val map = scala.collection.mutable.Map("" -> 0)
    
    def createPath(path: String, value: Int): Boolean = {
        if (map.contains(path)) return false
        if (!map.contains(path.substring(0, path.lastIndexOf('/')))) return false
        map(path) = value
        true
    }

    def get(path: String): Int = {
        map.getOrElse(path, -1)
    }

}

/**
 * Your FileSystem object will be instantiated and called as such:
 * var obj = new FileSystem()
 * var param_1 = obj.createPath(path,value)
 * var param_2 = obj.get(path)
 */