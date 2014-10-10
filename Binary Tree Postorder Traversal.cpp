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
    vector<int> postorderTraversal(TreeNode *root) {
        vector<int> result;
        if (!root) return result;
        TreeNode* prev = NULL;
        deque<TreeNode*> stack;
        stack.push_back(root);
        while(!stack.empty()) {
            TreeNode* p = stack.back();
            if (!prev || (prev != p && prev!=p->left && prev!=p->right)) {
                if (p->right) stack.push_back(p->right);
                if (p->left) stack.push_back(p->left);
            } else {
                stack.pop_back();
                result.push_back(p->val);
            }
            prev = p;
        }
        return result;
    }
};