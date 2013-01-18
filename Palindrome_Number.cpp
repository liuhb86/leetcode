class Solution {
public:
    bool isPalindrome(int x) {
        if(x<0) return false;
        int nDigit=1;
        int power=1;
        for(int t=x;t>=10;t/=10) {
            nDigit++;
            power*=10;
        }
        for(int i=0;i<(nDigit+1)/2;++i){
            int digit=x/power;
            int lowDigit = x%10;
            if (digit!=lowDigit) return false;
            x-=digit*power;
            x/=10;
            power/=100;
        }
        return true;
    }
};