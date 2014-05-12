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
    ListNode *swapPairs(ListNode *head) {
        ListNode** prevLink= &head;
        ListNode* curHead = head;
        while(true) {
            if (curHead == NULL)
            {
                *prevLink = NULL;
                break;
            }
            ListNode* pNext = curHead->next;
            if (pNext == NULL)
            {
                *prevLink = curHead;
                break;
            } else {
                ListNode* pNextHead = pNext->next;
                *prevLink = pNext;
                pNext->next = curHead;
                prevLink = &(curHead->next);
                curHead = pNextHead;
            }
        }
        return head;
    }
};