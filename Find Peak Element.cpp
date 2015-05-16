class Solution {
public:
    bool greaterThanPrev(const vector<int>& nums, size_t index) {
        if (index == 0) return true;
        return nums[index] > nums[index -1];
    }
    bool greaterThanNext(const vector<int>& nums, size_t index) {
        if (index == nums.size() -1) return true;
        return nums[index] > nums[index + 1];
    }
    
    int findPeakElement(const vector<int>& nums) {
        size_t begin = 0;
        size_t end = nums.size();
        while(begin < end) {
            int middle = begin + (end - begin) / 2;
            if (greaterThanPrev(nums, middle) && greaterThanNext(nums, middle)) {
                return middle;
            } else if (greaterThanPrev(nums, middle)) {
                // it's next is greater than middle
                begin = middle + 1;
            } else {
                // middle is greater than prev
                end = middle;
            }
        }
        return begin;
    }
};
