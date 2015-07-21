class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        vector<int> result;
        deque<int> que;
        if (nums.empty()) return result;
        int t = -k;
        for (int i =0;i<nums.size();++i) {
            while(!que.empty() && que.back()<nums[i]) que.pop_back();
            que.push_back(nums[i]);
            ++t;
            if (t>=0) {
                result.push_back(que.front());
                if (que.front()==nums[t]) que.pop_front();
            }
        }
        return result;
    }
};
