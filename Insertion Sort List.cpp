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
    ListNode *insertionSortList(ListNode *head) {
        if (!head) return NULL;
        ListNode* sorted = head;
        ListNode* toSort = head->next;
        head->next = NULL;
        while (toSort) {
            ListNode* q = toSort;
            toSort = toSort->next;
            ListNode** prev = &sorted;
            for (ListNode* p = sorted;; p=p->next) {
                if (!p || q->val < p->val) {
                    *prev = q;
                    q->next = p;
                    break;
                }
                prev = &(p->next);
            }
        }
        return sorted;
    }
};