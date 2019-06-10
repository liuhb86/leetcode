class Solution {
public:
    vector<int> sortArray(vector<int>& nums) {
        int* c = new int[100001]();
        for (auto it = nums.begin(); it!= nums.end(); ++it) c[(*it)+50000] += 1;
        int k = 0;
        for (int i = -50000; i<=50000; ++i ) {
            int x = c[i+50000]; 
            for (int j= 0; j<x; ++j) {
                nums[k++] = i;
            }
        }
        return nums;
    }
};