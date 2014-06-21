//ref :http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
class Solution {
public:
    int largestRectangleArea(vector<int> &height) {
        int largest = 0;
        stack<int> increasing;
        for (int i=0;i<=height.size();++i) {
            int ch = i == height.size() ? -1 : height[i];
            while (!increasing.empty() && ch<height[increasing.top()]) {
                int h = height[increasing.top()];
                increasing.pop();
                int left = increasing.empty()? 0 : increasing.top() + 1;
                int a = h * (i-left);
                if (a>largest) largest = a;
            }
            increasing.push(i);
            continue;
        }
        return largest;
    }
};
