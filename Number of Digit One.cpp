class Solution {
public:
    int countDigitOne(int n) {
        vector<int> digits;
        vector<int> total;
        int k=0;
        total.push_back(0);
        int t = n;
        while(t) {
            digits.push_back(t%10);
            t/=10;
            if (k==0) k=1; else k*=10;
            total.push_back(10*total.back()+k);
        }
        
        int count = 0;
        for (int i = digits.size() -1; i >=0; --i) {
            int d = digits[i];
            count += d * total[i];
            if (d > 1) count+=k;
            else if (d==1) count+= (n%k+1);
            k/=10;
        }
        
        return count;
    }
};
