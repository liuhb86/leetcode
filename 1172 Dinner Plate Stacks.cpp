class DinnerPlates {
public:
    DinnerPlates(int capacity) {
        cap = capacity;
    }
    
    ~DinnerPlates() {
      for (auto x : p) {
          delete x;
      }
    }
    
    void push(int val) {
        if (!pq.empty()) {
            int i = -pq.top();
            if (i<p.size()) {
                p[i]->push_back(val);
                if (p[i]->size() == cap) {
                  pq.pop();
                }
                //println(p.map(_.mkString(" ")).mkString(","))
                return;
              } else {
                priority_queue<int> emp;
                pq.swap(emp);
              }
        }
        vector<int>* nb = new vector<int>();
        nb->push_back(val);
        p.push_back(nb);
        if (cap != 1) {
            pq.push(-(p.size() - 1));
        }
        //println(p.map(_.mkString(" ")).mkString(","))
        //println(if (pq.nonEmpty) pq.head else "empty")        
    }
    
    int pop() {
        if (p.empty()) return -1;
        int v = p.back()->back();
        if (p.back()->size() == cap && cap != 1) {
          pq.push(-(p.size() - 1));
        }
        p.back()->pop_back();
        while (!p.empty() && p.back()->empty()) {
            delete p.back();
            p.pop_back();
        }
        return v;
    }
    
    int popAtStack(int index) {
        if (index >= p.size()) return -1;
        if (index == p.size() - 1) return pop();
        if (p[index]->empty()) return -1;
        int v = p[index]->back();
        if (p[index]->size() == cap) {
          pq.push(-index);
        }
        p[index]->pop_back();
        return v;
    }
    
private:
    vector<vector<int>*> p;
    priority_queue<int> pq;
    int cap;
};

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates* obj = new DinnerPlates(capacity);
 * obj->push(val);
 * int param_2 = obj->pop();
 * int param_3 = obj->popAtStack(index);
 */