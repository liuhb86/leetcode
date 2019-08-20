import scala.collection.mutable.{Queue, Set}
class SnakeGame(_width: Int, _height: Int, _food: Array[Array[Int]]) {

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    val q = Queue((0,0))
    val set = Set((0,0))
    var over = false
    var x = 0
    var y = 0
    var fi = 0

    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    def move(direction: String): Int = {
        if (over) return -1
        val (dx, dy) = direction match {
            case "U" => (0, -1)
            case "D" => (0,1)
            case "L" =>(-1, 0)
            case "R" => (1,0)
        }
        var nx = x + dx
        var ny = y + dy
        //print(nx, ny, _food(fi))
        if (nx < 0 || nx >=_width) {over = true; return -1}
        if (ny<0 || ny >=_height) {over = true; return -1}
        if (fi < _food.length && nx == _food(fi)(1) && ny == _food(fi)(0)) {
            fi += 1
        } else {
            set -= q.dequeue   
            if (set((nx, ny))) { over = true; return -1}
        }
        q += ((nx, ny))
        set += ((nx,ny))
        x = nx
        y = ny
        q.length - 1
    }

}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * var obj = new SnakeGame(width, height, food)
 * var param_1 = obj.move(direction)
 */