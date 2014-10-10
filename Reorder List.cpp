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
    void reorderList(ListNode *head) {
        int n = 0;
        for (ListNode* p = head; p!=NULL; p=p->next) ++n;
        int n1 = (n+1)/2;
        int n2 = n-n1;
        ListNode* head2 = head;
        for (int i=0;i<n1;++i) head2=head2->next;
        ListNode* prev = NULL;
        for (int i=0;i<n2;++i) {
            ListNode* p = head2->next;
            head2->next = prev;
            prev = head2;
            head2 = p;
        }
        head2 = prev;
        
        ListNode** prevLink = &head;
        ListNode* p = head;
        ListNode* p2 = head2;
        while(p!=head2) {
            *prevLink = p;
            prevLink = &(p->next);
            p = p->next;
            if (!p2) break;
            *prevLink = p2;
            prevLink = &(p2->next);
            p2=p2->next;
        }
        *prevLink = NULL;
    }
};