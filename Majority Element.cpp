class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int leftover = -1;
        while(true) {
            if (nums.size() == 0) return leftover;
            if (nums.size() == 1) return nums.back();
            int dest = 0;
            for (int src = 0; src < nums.size(); src += 2) {
                if (src ==nums.size() - 1) {
                    leftover = nums[src];
                    break;
                }
                if (nums[src] == nums[src+1]) {
                    nums[dest++] = nums[src];
                }
            }
            nums.resize(dest);
        }
    }
};
