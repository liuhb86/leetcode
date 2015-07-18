class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> result;
        unordered_map<int, int> hashtable;
        for (int i = 0; i<nums.size(); ++i) {
            hashtable[nums[i]] = i;
        }
        
        for (int i=0; i<nums.size(); ++i) {
            auto lResultIt = hashtable.find(target - nums[i]);
            if (lResultIt != hashtable.end() && lResultIt->second != i) {
                result.push_back(i + 1);
                result.push_back(lResultIt->second + 1);
                break;
            }
        }
        return result;
    }
};