class Solution {
public:
    int divide(int dividend, int divisor) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if (divisor==0) return 0;
        bool minus = false;
        if (dividend>0) {dividend = -dividend; minus = !minus;}
        if (divisor>0) {divisor = -divisor; minus = !minus;}
        
        int q = -1;
        int result =0;
        
        while(true) {
            int d = divisor << 1;
            if (d<dividend || d>divisor) break;
            q<<=1;
            divisor = d;
        }
        
        while(true){
            if (dividend <=divisor) {
                result+=q;
                dividend -=divisor;
            }
            if (q ==-1) break;
            q >>= 1;
            divisor>>=1;
        }
        
        if (!minus) result = - result;
        return result;
    }
};