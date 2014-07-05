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
    bool isSymmetric(TreeNode *root) {
        if (root == NULL) return true;
        deque<TreeNode*> q1;
        deque<TreeNode*> q2;
        q1.push_back(root->left);
        q2.push_back(root->right);
        while(!q1.empty()) {
            TreeNode* n1 = q1.back();
            q1.pop_back();
            TreeNode* n2 = q2.back();
            q2.pop_back();
            if (n1 == NULL || n2 == NULL) {
                if (n1 == n2) continue;
                else return false;
            }
            if (n1->val != n2->val) return false;
            q1.push_back(n1->left);
            q1.push_back(n1->right);
            q2.push_back(n2->right);
            q2.push_back(n2->left);
        }
        return true;
    }
};
