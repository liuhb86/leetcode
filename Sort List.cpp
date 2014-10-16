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
    ListNode *sortList(ListNode *head) {
        if (!head) return NULL;
        int n = 0;
        for (ListNode* p=head;p!=NULL;p=p->next) ++n;
        for (int k=1;k<n;k<<=1) {
            ListNode** prev = &head;
            ListNode* begin1 = head;
            while(begin1) {
                ListNode* begin2 = begin1;
                for (int i=0;i<k && begin2;++i) begin2 = begin2->next;
                if (!begin2) {*prev = begin1; prev = NULL; break;}
                int c1 = 0;
                int c2 = 0;
                while (c1<k && c2<k && begin2) {
                    if (begin1->val < begin2->val) {
                        *prev = begin1;
                        prev = &(begin1->next);
                        begin1 = begin1->next;
                        ++c1;
                    } else {
                        *prev = begin2;
                        prev = &(begin2->next);
                        begin2 = begin2->next;
                        ++c2;
                    }
                }
                while (c1<k) {
                    *prev = begin1;
                    prev = &(begin1->next);
                    begin1 = begin1->next;
                    ++c1;
                }
                while (c2<k && begin2) {
                    *prev = begin2;
                    prev = &(begin2->next);
                    begin2=begin2->next;
                    ++c2;
                }
                begin1 = begin2;
            }
            if (prev) *prev = NULL;
        }
        return head;
    }
};