class Solution {
public:
    const int N_ALPHABET = 26;
    string convertToTitle(int n) {
        --n;
        int base = N_ALPHABET;
        int ndigit = 1;
        while(n >= base) {
            n -= base;
            ++ndigit;
            if (base > INT_MAX / N_ALPHABET) {break;}   //base* N_ALPHABET >MAX_INT 
            base *= N_ALPHABET;
        }
        string result;
        result.resize(ndigit);
        for (int i = 0; i < ndigit; ++i) {
            result[ndigit - 1 - i] = 'A' + (n % N_ALPHABET);
            n /= N_ALPHABET;
        }
        return result;
    }
};
