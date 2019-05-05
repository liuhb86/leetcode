/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    int kthSmallest(TreeNode* root, int k) {
        int r;
        kthSmallest(root, k, r);
        return r;
    }
    
    bool kthSmallest(TreeNode* root, int k, int& r) {
        if (!root) { r=0; return false;}
        if (kthSmallest(root->left, k, r)) return true;
        if (k == r + 1) {r=root->val; return true;}
        int count = r + 1;
        if (kthSmallest(root->right, k-count, r)) return true;
        r += count;
        return false;
    }
};
