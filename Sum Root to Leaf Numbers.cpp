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
    int sumNumbers(TreeNode *root) {
        return sumNumbers(root, 0);
    }
    
    int sumNumbers(TreeNode* root, int sum) {
        if (!root) {
            return 0;
        }
        
        sum = sum* 10 + root->val;
        
        if (!root->left && !root->right) {
            return sum;
        }
        
        return sumNumbers(root->left, sum) + sumNumbers(root->right, sum);
    }
};
