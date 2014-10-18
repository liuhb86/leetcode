class Solution {
public:
    int evalRPN(vector<string> &tokens) {
        deque<int> stack;
        for (vector<string>::iterator it = tokens.begin(); it!=tokens.end(); ++it) {
            string& op = *it;
            if (op=="+" || op=="-" || op=="*" || op=="/") {
                int r2 = stack.back();
                stack.pop_back();
                int r1 = stack.back();
                stack.pop_back();
                int r;
                switch(op[0]) {
                    case '+': r=r1+r2; break;
                    case '-': r=r1-r2; break;
                    case '*': r=r1*r2; break;
                    case '/': r=r1/r2; break;
                }
                stack.push_back(r);
            } else {
                int r = atoi(op.c_str());
                stack.push_back(r);
            }
        }
        return stack.back();
    }
};