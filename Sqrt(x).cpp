//ref: https://en.wikipedia.org/wiki/Methods_of_computing_square_roots
// testing (r+e)^2=r*r+2*r*e+e*e < x, iterating on the bit e
// bit:=e*e; num:=x-r*r; res:=2*r*e;
// when unset: e'=e/2, bit'=bit/4, r'=r, num'=num, res'=2*r'*e'=2*r*e/2=res/2;
// when set:   e'=e/2, bit'=bit/4, r'=r+e, 
//             num'=x-(r+e)*(r+e)=x-r*r-2*r*e-e*e= num-res-bit,
//             res'=2*(r+e)*e/2= 2*r*e/2 + e*e = res/2+bit
class Solution {
public:
    int sqrt(int x) {
        int num = x;
        int res = 0;
        int bit = 1 << (sizeof(int)*8-2); // The second-to-top bit is set: 1 << 30 for 32 bits
     
        // "bit" starts at the highest power of four <= the argument.
        while (bit > num)
            bit >>= 2;
     
        while (bit != 0) {
            if (num >= res + bit) {
                num -= res + bit;
                res = (res >> 1) + bit;
            }
            else
                res >>= 1;
            bit >>= 2;
        }
        return res;
    }
};
