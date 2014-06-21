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
    ListNode *partition(ListNode *head, int x) {
        ListNode head1(-1);
        ListNode head2(-1);
        ListNode* p1 = &head1;
        ListNode* p2 = &head2;
        while(head!=NULL) {
            if (head->val < x) {
                p1->next = head;
                p1 = head;
            } else {
                p2->next = head;
                p2 = head;
            }
            head = head->next;
        }
        p2->next = NULL;
        p1->next = head2.next;
        return head1.next;
    }
};