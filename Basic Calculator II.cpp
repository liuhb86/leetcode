class Reader {
public:
    Reader(string& s):mStream(s), mbEof(false) {}
    
    int GetNumber() {
        int num = -1;
        if (mStream.eof()) return -1;
        mStream>>num;
        return num;
    }
    
    char GetOperator() {
        char p = '=';
        while(!mStream.eof()) {
            mStream>>p;
            if (p==' ') continue;
            return p;
        }
        return p;
    }
private:
    istringstream mStream;
    bool mbEof;
};

class Solution {
public:
    int calculate(string s) {
        deque<int> numStack;
        deque<char> opStack;
        Reader reader(s);
        bool lbGetNumber = true;
        while(true) {
            if (lbGetNumber) {
                int num = reader.GetNumber();
                if (num < 0)
                {
                    break;
                }
                numStack.push_back(num);
            } else {
                char op = reader.GetOperator();
                calculate(numStack, opStack, op);
            }
            lbGetNumber = !lbGetNumber;
        }
        return numStack.back();
    }
    
    int pred(char op) {
        switch(op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }
    
    int calc(int a, int b, char op) {
        switch(op) {
            case '+': return a+b;
            case '-': return a-b;
            case '*': return a*b;
            case '/': return a/b;
        }
        return 0;
    }
    void calculate(deque<int>& numStack, deque<char>& opStack, char op) {
        while(!opStack.empty() && pred(opStack.back()) >= pred(op)) {
            int b =numStack.back();
            numStack.pop_back();
            int a = numStack.back();
            numStack.pop_back();
            char op1 = opStack.back();
            opStack.pop_back();
            numStack.push_back(calc(a,b, op1));
        }
        opStack.push_back(op);
    }
};
