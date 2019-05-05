object Solution {
    def loudAndRich(richer: Array[Array[Int]], quiet: Array[Int]): Array[Int] = {
       new Solver(richer, quiet).solve()  
    }
}

class Solver(richer: Array[Array[Int]], quiet: Array[Int]) {
    val personCount = quiet.length
    val richerThanI = Array.fill[List[Int]](personCount)(Nil)
    for (r <- richer) {
        val x = r(0)
        val y = r(1)
        richerThanI(y) ::= x 
    }
    val answer = new Array[Int](personCount)
    val solved = Array.fill(personCount)(false)
    
    def solve() : Array[Int] = {
        for (person <- 0 until personCount) {
            _solve(person)
        }
        answer
    }
    
    def _solve(person: Int) : Int = {
        if (!solved(person)) {
            answer(person) = (person :: richerThanI(person).map(_solve)).minBy(quiet(_))
            solved(person) = true
        }
        answer(person)
    }
}