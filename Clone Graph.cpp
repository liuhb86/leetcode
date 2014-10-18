/**
 * Definition for undirected graph.
 * struct UndirectedGraphNode {
 *     int label;
 *     vector<UndirectedGraphNode *> neighbors;
 *     UndirectedGraphNode(int x) : label(x) {};
 * };
 */
class Solution {
public:
    UndirectedGraphNode *cloneGraph(UndirectedGraphNode *node) {
        if (!node) return NULL;
        deque<UndirectedGraphNode*> stack;
        UndirectedGraphNode* result = new UndirectedGraphNode(node->label);
        node->neighbors.push_back(result);
        node->neighbors.push_back(NULL);
        stack.push_back(node);
        while(!stack.empty()) {
            UndirectedGraphNode* p=stack.back();
            stack.pop_back();
            int k = p->neighbors.size();
            UndirectedGraphNode* p2= p->neighbors[k-2];
            for (int i = 0; i<k-2; ++i) {
                UndirectedGraphNode* next = p->neighbors[i];
                UndirectedGraphNode* next2;
                if (!next->neighbors.empty() && next->neighbors.back() == NULL) {
                    next2 = next->neighbors[next->neighbors.size()-2];
                } else {
                    next2 = new UndirectedGraphNode(next->label);
                    next->neighbors.push_back(next2);
                    next->neighbors.push_back(NULL);
                    stack.push_back(next);
                }
                p2->neighbors.push_back(next2);
            }
        }
        
        stack.push_back(node);
        while(!stack.empty()) {
            UndirectedGraphNode* p=stack.back();
            stack.pop_back();
            p->neighbors.pop_back();
            p->neighbors.pop_back();
            for (int i=0;i<p->neighbors.size();++i) {
                UndirectedGraphNode* next = p->neighbors[i];
                if (!next->neighbors.empty() && next->neighbors.back() == NULL) {
                    stack.push_back(next);
                }
            }
        }
        
        return result;
    }
};