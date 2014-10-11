class Solution {
public:
    string multiply(string num1, string num2) {
        string result;
        result.append(num1.size()+num2.size(), '0');
        bool negative = num1.front()=='-' ^ num2.front()=='-';
        int shift = 0;
        for (string::reverse_iterator it2= num2.rbegin(); it2!=num2.rend() && *it2>='0' && *it2<='9'; ++it2) {
            int mul = *it2-'0';
            int c=0;
            int k=shift;
            for (string::reverse_iterator it = num1.rbegin(); it!=num1.rend()&&*it>='0'&&*it<='9';++it) {
                int d = *it-'0';
                d = d*mul+c + (result[k]-'0');
                result[k] = d%10 +'0';
                c = d/10;
                ++k;
            }
            result[k] = c +'0';
            ++shift;
        }
        while(result.size()>1 && result.back()=='0') result.pop_back();
        if (negative && (result.size()>1 || result[0]!='0')) result.push_back('-');
        reverse(result.begin(),result.end());
        return result;
    }
};