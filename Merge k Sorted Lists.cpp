/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
    struct comp {
       bool operator() (ListNode* p1, ListNode* p2) const {
		return p1->val > p2->val;
       }
	};
public:
    ListNode *mergeKLists(vector<ListNode *> &lists) {
		priority_queue<ListNode*,vector<ListNode*>,comp> heap;
		for(vector<ListNode*>::iterator it=lists.begin();it!=lists.end();++it){
			if (*it!=NULL) heap.push(*it);
		}
		ListNode head(0);
		ListNode* p=&head;
		while(!heap.empty()){
			ListNode* list=heap.top();
			heap.pop();
			p->next = list;
			p= list;
			list = list->next;
			if (list!=NULL) heap.push(list);
		}
		p->next = NULL;
		return head.next;
    }
};