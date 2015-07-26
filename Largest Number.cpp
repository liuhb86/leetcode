class Solution {
public:
    string largestNumber(vector<int>& nums) {
        sort(nums.begin(), nums.end(), cmp);
        if (!nums.empty() && nums.front() == 0) return "0";
        ostringstream oss;
        for (auto it = nums.begin(); it!= nums.end();++it) {
            oss<<*it;
        }
        return oss.str();
    }
private:
    static bool cmp(const int a, const int b) {
        unsigned long long a1 = a;
        unsigned long long b1 = b;
        unsigned long long  p;
        for (p=10;p<=a1;p*=10);
        unsigned long long ba = b1*p+a1;
        for (p=10;p<=b1; p*=10) ;
        unsigned long long ab = a1*p+b1;
        return ba<ab;
    }
};
