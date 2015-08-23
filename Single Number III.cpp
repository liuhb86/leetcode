class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        unsigned int t=0;
        for (auto it = nums.begin(); it != nums.end(); ++it) t^=(*it);
        unsigned int k=1;
        while ((t&k)==0) k<<=1;
        int a=0, b=0;
        for (auto it=nums.begin(); it!=nums.end();++it) {
            int n = *it;
            if (n&k) a^=n; else b^=n;
        }
        vector<int> result;
        result.push_back(a);
        result.push_back(b);
        return result;
    }
};
