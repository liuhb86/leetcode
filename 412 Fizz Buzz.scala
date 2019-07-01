object Solution {
    def fizzBuzz(n: Int): List[String] = {
        (1 to n).toList.map(x=>
            if (x % 15 == 0) "FizzBuzz"
            else if (x% 3 ==0) "Fizz"
            else if (x%5==0) "Buzz"
            else x.toString
        )
    }
}