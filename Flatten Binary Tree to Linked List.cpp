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
    void flatten(TreeNode *root) {
        deque<TreeNode*> stack;
        deque<bool> first;
        TreeNode* prev = NULL;
        stack.push_back(root);
        first.push_back(true);
        
        while(!stack.empty()) {
            TreeNode* node = stack.back();
            if (node == NULL) {
                stack.pop_back();
                first.pop_back();
                continue;
            }
            
            if (first.back()) {
                first.back() = false;
                prev = node;
                TreeNode* t = node->right;
                node->right = node->left;
                node->left = t;
                stack.push_back(node->right);
                first.push_back(true);
                continue;
            }
            
            if (node->left) {
                TreeNode* t = node->left;
                prev->right = t;
                node->left = NULL;
                stack.push_back(t);
                first.push_back(true);
                continue;
            }
            
            stack.pop_back();
            first.pop_back();
        }
    }
    
};
