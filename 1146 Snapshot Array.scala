import scala.collection.mutable.ArrayBuffer
import scala.collection.immutable.Vector
class SnapshotArray(_length: Int) {
    
    val snaps = ArrayBuffer(Vector.fill(_length)(0))
    
    def set(index: Int, `val`: Int) {
        snaps(snaps.length - 1) = snaps.last.updated(index, `val`)
    }

    def snap(): Int = {
        snaps += snaps.last
        snaps.length - 2
    }

    def get(index: Int, snap_id: Int): Int = {
        snaps(snap_id)(index)
    }

}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * var obj = new SnapshotArray(length)
 * obj.set(index,`val`)
 * var param_2 = obj.snap()
 * var param_3 = obj.get(index,snap_id)
 */