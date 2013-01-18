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
    void addDigit(int d1,int d2, int& carry, ListNode*& prev){
            int sum = d1 + d2 + carry;
            carry=sum/10;
            int digit = sum%10;
            ListNode* newNode = new ListNode(digit);
            prev->next = newNode;
            prev = newNode;      
    }
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {
        int carry = 0;
        ListNode result = ListNode(0);
        ListNode* prev = &result;
        while(l1!=NULL && l2!=NULL){
            addDigit(l1->val,l2->val,carry,prev);
            l1=l1->next;
            l2=l2->next;
        }
        while(l1!=NULL){
            addDigit(l1->val,0,carry,prev);
            l1=l1->next;
        }
        while(l2!=NULL){
            addDigit(l2->val,0,carry,prev);
            l2=l2->next;
        }
        if (carry!=0){
            addDigit(0,0,carry,prev);
        }
        return result.next;
    }
};