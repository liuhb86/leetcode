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
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        mFoundOne = false;
        path.clear();
        return _lowestCommonAncestor(root, p, q);
    }
    
    TreeNode* _lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if (!root) return NULL;
        if (!mFoundOne) path.push_back(root);
        if (root == p || root ==q) {
            if (mFoundOne) return path.back();
            if (p==q) return root;
            mFoundOne = true;
        }
        TreeNode* r;
        r = _lowestCommonAncestor(root->left, p, q);
        if (r) return r;
        r = _lowestCommonAncestor(root->right, p, q);
        if (r) return r;
        if (path.back() == root) path.pop_back();
        return NULL;
    }
    
    bool mFoundOne;
    vector<TreeNode*> path;
};
