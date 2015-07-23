class Solution {
public:
    string fractionToDecimal(int numerator, int denominator) {
        ostringstream oss;
        long long n = numerator;
        long long d = denominator;
        bool neg = (numerator < 0) ^ (denominator < 0);
        if (neg && numerator!= 0) oss<<"-";
        n = abs(n);
        d = abs(d);
        oss << (n / d);
        long long r = n%d;
        if (r == 0) return oss.str();
        oss<<".";
        unordered_map<long long, int> pos;
        deque<int> digits;
        while (true){
            r *= 10;
            auto rit = pos.find(r);
            if (rit != pos.end()) {
                for (int i=0; i < rit->second; ++i) {
                    oss<<digits[i];
                }
                oss<<"(";
                for (int i=rit->second; i < digits.size(); ++i) {
                    oss<<digits[i];
                }
                oss<<")";
                break;
            }
            pos[r]=digits.size();
            int c = r/d;
            digits.push_back(c);
            r = r % d;
            if (r == 0) {
                for (int i=0; i <digits.size(); ++i) {
                    oss<<digits[i];
                }
                break;
            }
        }
        return oss.str();
    }
};
