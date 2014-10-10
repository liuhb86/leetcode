/**
 * Definition for singly-linked list with a random pointer.
 * struct RandomListNode {
 *     int label;
 *     RandomListNode *next, *random;
 *     RandomListNode(int x) : label(x), next(NULL), random(NULL) {}
 * };
 */
class Solution {
public:
    RandomListNode *copyRandomList(RandomListNode *head) {
        vector<RandomListNode*> link;

        for (RandomListNode* cur= head; cur!=NULL;) {
            RandomListNode* p = new RandomListNode(cur->label);
            link.push_back(cur);
            RandomListNode* next = cur->next;
            cur->next = p;
            cur = next;
        }
        
        RandomListNode* result = NULL;
        if (!link.empty()) result = link.front()->next;
        
        for (int i=0;i<link.size();++i) {
            link[i]->next->random = link[i]->random ? link[i]->random->next : NULL;
            if (i ==link.size()-1) {
                link[i]->next->next = NULL;
            } else {
                link[i]->next->next = link[i+1]->next;
            }
        }
        
        for (int i=0;i<link.size();++i) {
            if (i==link.size()-1) {
                link[i]->next = NULL;
            } else {
                link[i]->next = link[i+1];
            }
        }

        return result;
    }
};