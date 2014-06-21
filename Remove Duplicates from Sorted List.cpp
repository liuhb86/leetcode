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
        if (head == NULL) return NULL;
        ListNode* prev = head;
        for (ListNode* p=head->next; p!= NULL; p=p->next) {
            if (p->val==prev->val) {delete p; continue;}
            prev->next = p;
            prev = p;
        }
        prev->next = NULL;
        return head;
    }
};
