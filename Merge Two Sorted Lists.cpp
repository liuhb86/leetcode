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
    ListNode *mergeTwoLists(ListNode *l1, ListNode *l2) {
        ListNode* head = NULL;
        ListNode** p = &head;
        while(l1!= NULL && l2!=NULL)
        {
            ListNode** smaller = (l1->val<=l2->val) ? &l1 : &l2;
            *p = *smaller;
            p = &((*smaller)->next);
            *smaller = (*smaller)->next;
        }
        if (l1!= NULL)
            *p = l1;
        else
            *p = l2;
        return head;
    }
};
