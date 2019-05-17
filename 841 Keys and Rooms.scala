object Solution {
    def canVisitAllRooms(rooms: List[List[Int]]): Boolean = {
        val unlocked = new Array[Boolean](rooms.length)
        visit(rooms.toArray, unlocked, 0)
        unlocked.forall(_ == true)
    }
    
    def visit(rooms: Array[List[Int]], unlocked: Array[Boolean], i : Int) : Unit = {
        unlocked(i) = true
        for (r <- rooms(i)) {
            if (!unlocked(r)) {
                visit(rooms, unlocked, r)
            }
        }
    }
}