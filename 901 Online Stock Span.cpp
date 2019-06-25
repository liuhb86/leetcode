class StockSpanner {
public:
    
    vector<int> p;
    vector<int> c;
    
    StockSpanner() {
        
    }
    
    int next(int price) {
        int x = 1;
        while(!p.empty() && p.back() <= price) {
            x += c.back();
            p.pop_back();
            c.pop_back();
        }
        p.push_back(price);
        c.push_back(x);
        return x;
    }
    
};

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner* obj = new StockSpanner();
 * int param_1 = obj->next(price);
 */