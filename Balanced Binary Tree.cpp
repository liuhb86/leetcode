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
    bool isBalanced(TreeNode *root) {
        int h;
        return isBalHeight(root, h);
    }
    
    bool isBalHeight(TreeNode* root, int& height) {
        if (!root) {
            height = 0;
            return true;
        }
        
        int h1, h2;
        if (!isBalHeight(root->left, h1)) return false;
        if (!isBalHeight(root->right, h2)) return false;
        if (abs(h1-h2) > 1) return false;
        height = std::max(h1, h2) + 1;
        return true;
    }
};
