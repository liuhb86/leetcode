class Solution {
public:
    uint32_t reverseBits(uint32_t n) {
        uint32_t r = 0;
        uint32_t p = 1<<31;
        while(n) {
            if (n&1) r += p;
            n>>=1;
            p>>=1;
        }
        return r;
    }
};