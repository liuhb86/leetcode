class Solution {
public:
    int nthUglyNumber(int n) {
        if (n<=0) return 0;
        if (ugly.empty()) ugly.push_back(1);
        while(ugly.size() < n) {
            int minNum = ugly[i2] * 2;
            int* p = &i2;
            int k = ugly[i3] * 3;
            if (k<minNum) {minNum=k; p = &i3;}
            k = ugly[i5] *5;
            if (k<minNum) {minNum=k; p=&i5;}
            ++(*p);
            if (minNum>ugly.back()) ugly.push_back(minNum);
        }
        return ugly[n-1];
    }
    static vector<int> ugly;
    static int i2;
    static int i3;
    static int i5;
};

vector<int> Solution::ugly;
int Solution::i2 = 0;
int Solution::i3 = 0;
int Solution::i5 = 0;
