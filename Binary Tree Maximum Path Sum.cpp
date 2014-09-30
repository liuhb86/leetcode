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
    int maxPathSum(TreeNode *root) {
        int m;
        return maxPathSum(root, m);
    }
    
    int maxPathSum(TreeNode *root, int &maxToRoot) {
        if (!root) {
            maxToRoot = 0;
            return INT_MIN;
        }
        int slr, srr;
        int sl = maxPathSum(root->left, slr);
        int sr = maxPathSum(root->right, srr);
        maxToRoot = max(slr, srr) + root->val;
        if (maxToRoot < 0) maxToRoot = 0;
        return max(max(sl,sr), slr + srr + root->val);
    }
};