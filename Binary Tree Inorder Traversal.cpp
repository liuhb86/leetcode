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
    vector<int> inorderTraversal(TreeNode *root) {
        vector<int> result;
        deque<TreeNode*> stack;
        bool isReturn = false;
        stack.push_back(root);
        while(!stack.empty()) {
            TreeNode* node = stack.back();
            if (node == NULL) {
                isReturn = true;
                stack.pop_back();
                continue;
            }
            if (isReturn) {
                stack.pop_back();
                result.push_back(node->val);
                stack.push_back(node->right);
                isReturn = false;
            }
            else {
                stack.push_back(node->left);
            }
        }
        return result;
    }
};
