class Solution {
public:
    bool isValid(string s) {
        deque<char> bracket;
        for(int i=0;i<s.size();++i){
            char c=s.at(i);
            if (c=='(' || c=='[' || c=='{'){
                bracket.push_back(c);
            } else if (c==')' || c==']' || c=='}'){
                if(bracket.empty()) return false;
                char b;
                switch (c){
                    case ')':b='(';break;
                    case ']':b='[';break;
                    case '}':b='{';break;
                }
                if(b!=bracket.back()) return false;
                bracket.pop_back();
            }
        }
        return bracket.empty();
    }
};