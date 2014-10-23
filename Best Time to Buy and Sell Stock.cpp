class Solution {
public:
    int maxProfit(vector<int> &prices) {
        if (prices.empty()) return 0;
        int minPrice = prices[0];
        int result = 0;
        for (int i=0;i<prices.size();++i) {
            result = max(result, prices[i]-minPrice);
            minPrice=min(minPrice, prices[i]);
        }
        return result;
    }
};