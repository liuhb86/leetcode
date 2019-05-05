class Queue {
public:
    // Push element x to the back of queue.
    void push(int x) {
        reverseQ.push_back(x);
    }

    // Removes the element from in front of queue.
    void pop(void) {
        move();
        Q.pop_back();
    }

    // Get the front element.
    int peek(void) {
        move();
        return Q.back();
    }

    // Return whether the queue is empty.
    bool empty(void) {
        return Q.empty() && reverseQ.empty();
    }
    
    void move() {
        if (!Q.empty()) return;
        while(!reverseQ.empty()) {
            Q.push_back(reverseQ.back());
            reverseQ.pop_back();
        }
    }
    
    deque<int> reverseQ;
    deque<int> Q;
};
