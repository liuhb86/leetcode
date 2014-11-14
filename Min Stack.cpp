class MinStack {
public:
    void push(int x) {
        data.push_back(x);
        if (minimum.empty() || x<=minimum.back()) minimum.push_back(x);
    }

    void pop() {
        if (data.back()==minimum.back()) minimum.pop_back();
        data.pop_back();
    }

    int top() {
        return data.back();
    }

    int getMin() {
        return minimum.back();
    }
private:
    deque<int> data;
    deque<int> minimum;
};