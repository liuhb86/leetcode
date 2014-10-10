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
    bool hasCycle(ListNode *head) {
        ListNode* p2 = head;
        while(head && p2) {
            head = head->next;
            p2 = p2->next;
            if (!p2) return false;
            p2 = p2->next;
            if (head==p2) return true;
        }
        return false;
    }
};