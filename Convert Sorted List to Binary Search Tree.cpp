/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode *sortedListToBST(ListNode *head) {
        int len = 0;
        for (ListNode* p = head; p != NULL; p = p->next) ++len;
        return makeBST(head, len);
    }
    
    TreeNode* makeBST(ListNode*& head, int size) {
        if (size == 0) return NULL;
        int leftSize = size/2;
        TreeNode* left = makeBST(head, leftSize);
        TreeNode* root = new TreeNode(head->val);
        root->left = left;
        head = head->next;
        root->right = makeBST(head, size - leftSize - 1);
        return root;
    }
};