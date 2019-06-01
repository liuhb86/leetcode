// https://en.wikipedia.org/wiki/Inverse_transform_sampling
import scala.util.Random
import scala.math.{sqrt, sin, cos, Pi}
class Solution(_radius: Double, _x_center: Double, _y_center: Double) {

  def randPoint(): Array[Double] = {
    val r = sqrt((1.0 -Random.nextDouble)) * _radius
    val theta = Random.nextDouble * 2.0 * Pi
    Array(_x_center + r * sin(theta), _y_center + r* cos(theta))
  }

}

/**
  * Your Solution object will be instantiated and called as such:
  * var obj = new Solution(radius, x_center, y_center)
  * var param_1 = obj.randPoint()
  */