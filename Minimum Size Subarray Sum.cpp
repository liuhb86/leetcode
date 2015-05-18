class Solution {
public:
    int minSubArrayLen(int s, vector<int>& nums) {
        long long sum = 0;
        size_t begin = 0;
        size_t end0 = 0;
        for (end0 = 0; end0 < nums.size(); ++end0) {
            sum += nums[end0];
            if (sum >= s) {
                break;
            }
        }
        if (sum < s) return 0;
        int minLength = end0 + 1;
        sum -= nums[end0];
        for (size_t iEnd = end0 ; iEnd < nums.size(); ++iEnd) {
            sum += nums[iEnd];
            while(sum - nums[begin] >= s) {
                sum -= nums[begin];
                ++begin;
            }
            int length = iEnd - begin + 1;
            if (length < minLength) minLength = length;
        }
        return minLength;
    }
};
