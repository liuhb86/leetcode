/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
 //ref: morris traverse: http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
class Solution {
public:
    void recoverTree(TreeNode *root) {
        int nDisorder = 0;
        TreeNode* n1 = NULL;
        TreeNode* n2 = NULL;
        TreeNode* cur = root;
        TreeNode* prev = NULL;
        while (cur != NULL) {
            if (cur->left != NULL) {
                TreeNode* pred = cur->left;
                while(pred->right != NULL && pred->right != cur) pred = pred->right;
                if (pred->right == NULL) {
                    pred->right = cur;
                    cur = cur->left;
                    continue;
                }
                pred->right = NULL;
            }
            if (prev != NULL && prev->val > cur->val) {
                if (nDisorder == 0) {
                    nDisorder = 1;
                    n1 = prev;
                    n2 = cur;
                } else {
                    nDisorder = 2;
                    n2 = cur;
                }
            }
            prev = cur;
            cur = cur->right;
        }
        if (nDisorder > 0) {
            int t = n1->val;
            n1->val = n2->val;
            n2->val = t;
        }
    }
};
