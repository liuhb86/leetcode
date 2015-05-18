class Solution {
public:
    int trailingZeroes(int n) {
        int count = 0;
        int five = 5;
        while (five <= n) {
            count += n / five;
            if (n / five < 5) break;
            five *= 5;
        }
        return count;
    }
};
