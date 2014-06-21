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
    ListNode *reverseBetween(ListNode *head, int m, int n) {
        if (head == NULL) return NULL;
        ListNode** phead = &head;
        m--;
        n -=m;
        for (int i=0;i<m;++i) phead = &((*phead)->next);
        ListNode* pFirst = *phead;
        ListNode* pRev = NULL;
        ListNode* pNext = *phead;
        for (int i=0;i<n;++i) {
            ListNode* pCur = pNext;
            pNext = pCur->next;
            pCur->next = pRev;
            pRev = pCur;
        }
        *phead = pRev;
        pFirst->next = pNext;
        return head;
        
    }
};
