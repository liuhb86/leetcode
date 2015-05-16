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
    size_t getListLength(ListNode* head) {
        size_t len = 0;
        while(head) {
            ++len;
            head = head->next;
        }
        return len;
    }
    
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        size_t lenA = getListLength(headA);
        size_t lenB = getListLength(headB);
        if (lenA > lenB) {
            swap(headA, headB);
            swap(lenA, lenB);
        }
        size_t delta = lenB - lenA;
        for (size_t i = 0; i < delta; ++i) {
            headB = headB->next;
        }
        while(headA != headB) {
            headA = headA->next;
            headB = headB->next;
        }
        return headA;
    }
};
