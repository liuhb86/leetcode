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
    vector<int> preorderTraversal(TreeNode *root) {
        vector<int> result;
        TreeNode* cur = root;
        while(cur) {
            if (!cur->left) {
                result.push_back(cur->val);
                cur = cur->right;
                continue;
            }
            
            TreeNode* prev = cur->left;
            while(prev->right != NULL && prev->right != cur) prev = prev->right;
            if (prev->right) {
                prev->right = NULL;
                cur = cur->right;
            } else {
                result.push_back(cur->val);
                prev->right = cur;
                cur = cur->left;
            }
        }
        return result;
    }
};