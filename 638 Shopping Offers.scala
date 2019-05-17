import scala.collection.mutable.Map
object Solution {
    val MaxItem = 6
    def shoppingOffers(price: List[Int], special: List[List[Int]], needs: List[Int]): Int = {
        val n = price.length
        val offers = special.map(_.toArray).toArray
        val offerSize = offers.map(_.dropRight(1).sum)
        val cache = Map[Int, Int]()
        solve(needs.toArray, needs.sum, price.toArray, offers.zip(offerSize), cache)
    }
    
    def solve(needs: Array[Int], needSize: Int, price: Array[Int], offers: Array[(Array[Int], Int)], cache: Map[Int, Int]) : Int = {
        if (needSize == 0) return 0
        val cacheKey = getKey(needs)
        val cached = cache.get(cacheKey)
        if (cached.isDefined) return cached.get
        var minPrice = needs.zip(price).map{case (n, p) => n*p}.sum
        for ((offer, offerSize) <- offers) {
            if (offerSize <= needSize && offer.last <= minPrice) {
                val left = needs.zip(offer).map{
                    case(a,b) => a-b
                }
                if (left.forall(_ >= 0)) {
                    val p = offer.last + solve(left, needSize - offerSize, price, offers, cache)
                    if (p < minPrice) minPrice = p
                }
            }
        }
        cache(cacheKey) = minPrice
        //println(s"${needs.mkString(",")}:$minPrice")
        minPrice
    }
    
    def getKey(needs: Array[Int]) : Int = {
        var result = 0
        needs.foreach(x => result = result * (MaxItem +1) + x)
        result
    }
}