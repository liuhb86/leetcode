class Solution {
public:
    int longestValidParentheses(string s) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int validStart = -1;
        int longest = 0;
        deque<int> stack;
        for (int i=0;i<s.size(); ++i) {
            char c = s[i];
            if (c=='(') {
              if (validStart>=0) stack.push_back(validStart);
              else stack.push_back(i);
              validStart = -1;
            } else if (c==')') {
                if (stack.empty()) validStart = -1;
                else {
                    validStart = stack.back();
                    stack.pop_back();
                    int len = i-validStart+1;
                    if (len>longest) longest = len;
                }
            }
        }
        
        return longest;
    }
};