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
    ListNode *removeNthFromEnd(ListNode *head, int n) {
        if (n<=0) return head;
        if (head==NULL) return head;
        ListNode *p,*q;
        p=head;
        for(int i=0;i<n;++i) {
            if(p==NULL) return head;
            p=p->next;
        }
        if (p==NULL) {
            q=head->next;
            delete head;
            return q;
        }
        for(q=head;p->next!=NULL;){
            p=p->next;
            q=q->next;
        }
        p=q->next;
        q->next=q->next->next;
        delete p;
        return head;
    }
};