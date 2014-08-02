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
    int minDepth(TreeNode *root) {
        if (!root) return 0;
        int d1 = minDepth(root->left);
        int d2 = minDepth(root->right);
        if (d1 == 0) return d2 + 1;
        if (d2 == 0) return d1 + 1;
        return std::min(d1, d2) + 1;
    }
};
