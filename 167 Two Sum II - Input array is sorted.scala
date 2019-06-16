object Solution {
    def twoSum(numbers: Array[Int], target: Int): Array[Int] = {
        var i = 0
        var j = numbers.length - 1
        while(i<j) {
            val s = numbers(i) + numbers(j)
            if (s==target) return Array(i+1,j+1)
            else if (s<target) i+=1
            else j-=1
        }
        throw new Exception()
    }
}