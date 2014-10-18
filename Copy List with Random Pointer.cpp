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

        for (RandomListNode* cur= head; cur!=NULL;) {
            RandomListNode* p = new RandomListNode(cur->label);
            RandomListNode* next = cur->next;
            cur->next = p;
            p->next = next;
            cur = next;
        }
        
        for (RandomListNode* p = head; p!=NULL; p=p->next->next) {
            p->next->random = p->random ? p->random->next : NULL;
        }

        RandomListNode* result = NULL;
        
        RandomListNode** tail1 = &head;
        RandomListNode** tail2 = &result;
        
        RandomListNode* p = head;
        while(p) {
            *tail1 = p;
            tail1 = &(p->next);
            p = p->next;
            *tail2 = p;
            tail2 = &(p->next);
            p = p->next;
        }
        *tail1 = NULL;
        *tail2 = NULL;

        return result;
    }
};