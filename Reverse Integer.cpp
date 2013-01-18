class Solution {
public:
    int reverse(int x) {
        int output=0;
        bool negative = x<0;
        if (negative) x=-x;
        int power = 1;
        for(int t=x;t>=10;t/=10) {
            power*=10;
        }
        while(x>0){
            int digit=x%10;
            x=x/10;
            output+=digit*power;
            power/=10;
        }
        if(negative) output=-output;
        return output;
    }
};