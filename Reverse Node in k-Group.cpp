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
    ListNode *reverseKGroup(ListNode *head, int k) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if (head == NULL) return head;
        if (k<=1) return head;
        ListNode headNode(0);
        headNode.next = head;
        
        ListNode * prevTail = &headNode;
        
        while (head!=NULL) {
            ListNode * tail = head;
            for (int i=1; i<k;++i){
                if (tail ==NULL) break;
                tail = tail->next;
            }
            if (tail ==NULL) {
                prevTail->next = head;
                break;
            }
            ListNode * nextHead = tail->next;
            prevTail ->next = tail;
            ListNode *p=head,*q=head->next;
            do {
                ListNode* t= q->next;
                q->next = p;
                p = q;
                q = t;
            } while (p!=tail);
            head-> next = nextHead;
            prevTail = head;
            head = nextHead;
        }
        return headNode.next;
    }
};