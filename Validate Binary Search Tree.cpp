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
    bool isValidBST(TreeNode *root) {
        if (!root) return true;
        int min, max;
        return isValidBST(root, min,max);
    }
    bool isValidBST(TreeNode* node, int& min, int& max) {
        min = node->val;
        max = node->val;
        if (node->left) {
            int t = node->val;
            bool r = isValidBST(node->left, min, t);
            if (!r || t>=node->val) return false;
        }
        if (node->right) {
            int t = node->val;
            bool r = isValidBST(node->right, t, max);
            if (!r || t<=node->val) return false;
        }
        return true;
    }
};
