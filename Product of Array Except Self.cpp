class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        vector<int> result;
        if (nums.empty()) return result;
        result.reserve(nums.size());
        int product = 1;
        for (auto it = nums.begin(); it != nums.end(); ++it) {
            product *= (*it);
            result.push_back(product);
        }
        product = 1;
        auto leftIt = result.rbegin();
        auto inputIt = nums.rbegin();
        for (auto it = result.rbegin(); it != result.rend(); ++it, ++inputIt) {
            ++leftIt;
            *it = (leftIt == result.rend()) ? product : ((*leftIt) * product);
            product *= (*inputIt);
        }
        return result;
    }
};
