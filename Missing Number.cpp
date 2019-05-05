class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int n =nums.size();
        int missing = n;
        for (int i = 0; i< n; ++i) {
            int k = nums[i];
            while(k!=i && k!=n && k!=-1) {
                int t = nums[k];
                nums[k] = k;
                k = t;
            }
            if (k!=i) {
                missing = i;
                nums[i] = -1;
            }
        }
        return missing;
    }
};
