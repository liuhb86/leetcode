object Solution {
    def flipLights(n: Int, m: Int): Int = {
        (n, m) match {
            case (0, _) => 1
            case (_, 0) => 1
            case(1,_) => 2
            case (2,1) => 3
            case (2,_) => 4
            case (_, 1) => 4
            case (_, 2) => 7
            case (_,_) => 8
        }
    }
}