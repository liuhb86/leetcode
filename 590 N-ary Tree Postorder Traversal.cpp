/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/
struct Pair {
    Node* p;
    int index;
    Pair(Node* _p, int _index) : p(_p), index(_index) {}
};

class Solution {
public:
    vector<int> postorder(Node* root) {
        vector<int> r;
        if (root == nullptr) return r;
        deque<Pair> s;
        s.push_back(Pair(root, 0));
        while (!s.empty()) {
            if (s.back().index == s.back().p->children.size()) {
                r.push_back(s.back().p->val);
                s.pop_back();
            } else {
                Node* n = s.back().p->children[s.back().index];
                s.back().index += 1;
                s.push_back(Pair(n, 0));
            }
        }
        return r;
    }
};