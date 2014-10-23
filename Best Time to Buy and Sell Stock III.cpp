class Solution {
public:
    int maxProfit(vector<int> &prices) {
        if (prices.empty()) return 0;
        vector<int> maxProfitSince(prices.size());
        int maxPrice=prices.back();
        int maxProfitEver = 0;
        for (int i=prices.size()-1; i>=0;--i) {
            maxPrice=max(maxPrice, prices[i]);
            maxProfitEver = max(maxProfitEver, maxPrice-prices[i]);
            maxProfitSince[i] = maxProfitEver;
        }
        
        int result=0;
        maxProfitEver =0;
        int minPrice=prices.front();
        for (int i=0;i<prices.size();++i) {
            minPrice = min(minPrice, prices[i]);
            maxProfitEver = max(maxProfitEver, prices[i]-minPrice);
            result = max(result, maxProfitEver+maxProfitSince[i]);
        }
        
        return result;
    }
};