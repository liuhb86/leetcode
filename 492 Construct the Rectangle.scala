import scala.math.{sqrt, floor}
object Solution {
    def constructRectangle(area: Int): Array[Int] = {
        var w = floor(sqrt(area)).toInt
        while (area % w != 0) w -= 1
        Array(area/w, w)
    }
}