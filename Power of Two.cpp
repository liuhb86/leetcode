class Solution {
public:
    bool isPowerOfTwo(int n) {
        int k = 0;
        while(n) {
            k += (n&1);
            if (k>1) return false;
            n>>=1;
        }
        return (k==1);
    }
};
