/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *deleteDuplicates(ListNode *head) {
        ListNode* newHead = NULL;
        ListNode** prevLink = &newHead;
        ListNode* p = head;
        while(p!=NULL) {
            ListNode* q= p->next;
            if (q==NULL) {*prevLink = p; prevLink = &(p->next); break;}
            while(q && p->val==q->val) q=q->next;
            if (q==p->next) {*prevLink = p;prevLink = &(p->next);}
            p = q;
        }
        *prevLink = NULL;
        return newHead;
    }
};
