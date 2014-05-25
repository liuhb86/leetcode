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
    ListNode *rotateRight(ListNode *head, int k) {
        if (!head || head->next == NULL || k <= 0) return head;
        ListNode* p = head;
        int len = -1;
        for (int i = 0; i < k; ++i) {
            if (p->next == NULL) {
                len = i + 1;
                break;
            }
            p = p->next;
        }
        if (len > 0) return rotateRight(head, k%len);
        ListNode* s= head;
        while(p->next!=NULL) {p=p->next;s=s->next;}
        ListNode* pNewHead = s->next;
        p->next = head;
        s->next = NULL;
        return pNewHead;
    }
};