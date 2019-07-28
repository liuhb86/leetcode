object Solution {
    def isOneBitCharacter(bits: Array[Int]): Boolean = {
        var i = 0
        var lastBit = 0
        while (i < bits.length) {
            lastBit = bits(i)
            if (lastBit == 0) i+=1 else i+=2
        }
        lastBit == 0
    }
}