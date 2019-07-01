object Solution {
    def findRelativeRanks(nums: Array[Int]): Array[String] = {
        nums.zipWithIndex.sortBy(-_._1).zipWithIndex.sortBy(_._1._2).map(_._2).map{
            case 0 => "Gold Medal"
            case 1 => "Silver Medal"
            case 2 => "Bronze Medal"
            case x => (x+1).toString
        }
    }
}