class Solution {
public:
    int jump(vector<int>& nums) {
        if (nums.empty()) return 0;
        int n = nums.size();
        vector<int> minStep(n);
        minStep[n-1] = 0;
        for (int i = n-2; i >= 0; --i) {
            int d = i + nums[i];
            minStep[i] = n;
            int m = (d>=n) ? 1 : minStep[d] + 1;
            minStep[i] = m;
            for (int j = i + 1; minStep[j]>m;++j) minStep[j] = m;
        }
        return minStep[0];
    }
};
