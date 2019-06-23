import scala.collection.mutable.{Map, Set, PriorityQueue, ArrayBuffer}
class Twitter() {

    /** Initialize your data structure here. */
    var time = 0
    val tweets = Map[Int, List[(Int, Int)]]()
    val follows = Map[Int, Set[Int]]()

    /** Compose a new tweet. */
    def postTweet(userId: Int, tweetId: Int) {
        tweets(userId) = (tweetId, time) :: tweets.getOrElse(userId, Nil)
        time += 1
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    def getNewsFeed(userId: Int): List[Int] = {
        val pq = new PriorityQueue[List[(Int, Int)]]()(Ordering.by(_.head._2))
        val t = tweets.getOrElse(userId, Nil)
        if (t != Nil) pq += t
        for (f<- follows.getOrElse(userId, Set())) {
            val t = tweets.getOrElse(f, Nil)
            if (t!= Nil) pq += t
        }
        val r = new ArrayBuffer[Int](10)
        while (pq.nonEmpty && r.length < 10) {
            val (t, time) :: tail = pq.dequeue
            r += t
            if (tail != Nil) pq += tail
        }
        r.toList
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    def follow(followerId: Int, followeeId: Int) {
        if (followerId == followeeId) return
        follows.getOrElseUpdate(followerId, Set[Int]()) += followeeId
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    def unfollow(followerId: Int, followeeId: Int) {
        follows.getOrElseUpdate(followerId, Set[Int]()) -= followeeId
    }

}

/**
 * Your Twitter object will be instantiated and called as such:
 * var obj = new Twitter()
 * obj.postTweet(userId,tweetId)
 * var param_2 = obj.getNewsFeed(userId)
 * obj.follow(followerId,followeeId)
 * obj.unfollow(followerId,followeeId)
 */