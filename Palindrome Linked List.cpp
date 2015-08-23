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
    bool isPalindrome(ListNode* head) {
        int len = 0;
        ListNode* p = head;
        while(p) {++len;p=p->next;}
        int half = len/2;
        p = head;
        for (int i=0; i<half;++i) p=p->next;
        ListNode* q = NULL;
        while (p) {
            ListNode* next = p->next;
            p->next = q;
            q = p;
            p = next;
        }
        while(head && q) {
            if (head->val != q->val) return false;
            head = head->next;
            q = q->next;
        }
        return true;
    }
};
