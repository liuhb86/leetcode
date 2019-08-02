class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& T) {
        vector<int> r(T.size());
        deque<int> stack;
        for(int i=0; i< T.size(); ++i) {
            int t = T[i];
            while(!stack.empty() && t > T[stack.back()]) {
                r[stack.back()] = i - stack.back();
                stack.pop_back();
            }
            stack.push_back(i);
        }
        for (int i : stack) {
            r[i] = 0;
        }
        return r;
    }
};